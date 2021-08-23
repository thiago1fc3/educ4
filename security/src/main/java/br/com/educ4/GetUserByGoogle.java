package br.com.educ4;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.security.GetUserByGooglePort;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Collections.singletonList;

@Service
@RequiredArgsConstructor
public class GetUserByGoogle implements GetUserByGooglePort {

    private final static String GOOGLE_CLIENT_ID = "310551170823-9pjkdouq7jq56o5cotrde3pmakq3bqmu.apps.googleusercontent.com";

    public User execute(String token) {

        var idToken = verify(token);

        var payload = idToken.getPayload();

        return User.builder()
                .picture((String) payload.get("picture"))
                .username(payload.getEmail())
                .name((String) payload.get("name"))
                .enabled((boolean) payload.get("email_verified"))
                .build();
    }

    private GoogleIdToken verify(String token) {
        try {
            var gVerifier = new GoogleIdTokenVerifier
                    .Builder(new ApacheHttpTransport(), new GsonFactory())
                    .setAudience(singletonList(GOOGLE_CLIENT_ID))
                    .build();

            return gVerifier.verify(token);

        } catch (GeneralSecurityException | IOException e) {
            throw new IllegalArgumentException("Token Google not is valid!");
        }
    }

}

