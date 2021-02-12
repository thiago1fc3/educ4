package br.com.educ4.controller.auth;

import br.com.educ4.AuthUser;
import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Collections.singletonList;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final HttpServletRequest request;
    private final AuthUser authUser;
    private final FindUserByIdPort findUserByIdPort;

    @PostMapping("google")
    public String auth(@RequestBody String id_token) throws GeneralSecurityException, IOException {

        var gVerifier = new GoogleIdTokenVerifier.Builder(new ApacheHttpTransport(), new GsonFactory())
                .setAudience(singletonList("768834812579-007e5802er7gj3c93p8qa9568h8bj3na.apps.googleusercontent.com"))
                .build();

        var idToken = gVerifier.verify(id_token);
        if (idToken != null) {
            var payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
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
