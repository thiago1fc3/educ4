package br.com.educ4.controller.auth;

import br.com.educ4.controller.auth.request.TokenRequest;
import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.ports.driver.user.ExistsUserByUsernamePort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Collections.singletonList;

@RestController
@RequestMapping("auth/google")
@RequiredArgsConstructor
public class AuthGoogleController {

    private final CreateUserPort createUserPort;
    private final FindUserByUsernamePort findUserByUsernamePort;

    private final ExistsUserByUsernamePort existsUserByUsernamePort;

    private final String clientId = "310551170823-9pjkdouq7jq56o5cotrde3pmakq3bqmu.apps.googleusercontent.com";

    @PostMapping
    public User auth(@RequestBody TokenRequest request) throws GeneralSecurityException, IOException {

        var gVerifier = new GoogleIdTokenVerifier.Builder(new ApacheHttpTransport(), new GsonFactory())
                .setAudience(singletonList(clientId))
                .build();

        var idToken = gVerifier.verify(request.getIdToken());

        if (idToken != null) {
            var payload = idToken.getPayload();

            var existsUser = existsUserByUsernamePort.execute(payload.getEmail());

            if (!existsUser) {
                var user = User.builder()
                        .picture((String) payload.get("picture"))
                        .username(payload.getEmail())
                        .name((String) payload.get("name"))
                        .enabled(true)
                        .build();

                return createUserPort.execute(user);

            }

            return findUserByUsernamePort.execute(payload.getEmail(), User.class);

        }

        return null;
    }
}
