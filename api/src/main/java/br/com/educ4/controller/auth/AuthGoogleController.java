package br.com.educ4.controller.auth;

import br.com.educ4.AuthUser;
import br.com.educ4.controller.auth.request.TokenRequest;
import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Collections.singletonList;

@RestController
@RequestMapping("auth/google")
@RequiredArgsConstructor
public class AuthGoogleController {

    private final AuthUser authUser;
    private final FindUserByIdPort findUserByIdPort;
    private final String clientId = "310551170823-9pjkdouq7jq56o5cotrde3pmakq3bqmu.apps.googleusercontent.com";

    @PostMapping
    public String auth(@RequestBody TokenRequest request) throws GeneralSecurityException, IOException {

        var gVerifier = new GoogleIdTokenVerifier.Builder(new ApacheHttpTransport(), new GsonFactory())
                .setAudience(singletonList(clientId))
                .build();

        var idToken = gVerifier.verify(request.getIdToken());

        if (idToken != null) {
            var payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getEmail();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");
        }

        return "OK";
    }

    @GetMapping("me")
    public User me() {
        return findUserByIdPort.execute(authUser.getId(), User.class);
    }
}
