package br.com.educ4;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.security.AuthUserPort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.v2.ApacheHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHeaders;
import org.bson.types.ObjectId;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.security.GeneralSecurityException;
import java.util.Objects;

import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;

@Named
@RequiredArgsConstructor
public class AuthUser implements AuthUserPort {

    private final static String GOOGLE_CLIENT_ID = "310551170823-9pjkdouq7jq56o5cotrde3pmakq3bqmu.apps.googleusercontent.com";
    private final FindUserByUsernamePort findUserByUsernamePort;
    private final HttpServletRequest request;

    public User getUser() throws GeneralSecurityException, IOException {

        var authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.isNull(authorizationHeader))
            throw new AccessDeniedException("Access Denied!");

        var token = authorizationHeader.substring("Google".length()).trim();

        if (nonNull(token)) {

            var gVerifier = new GoogleIdTokenVerifier.Builder(new ApacheHttpTransport(), new GsonFactory())
                    .setAudience(singletonList(GOOGLE_CLIENT_ID))
                    .build();

            var idToken = gVerifier.verify(token);

            if (idToken != null) {
                var payload = idToken.getPayload();

                return User.builder()
                        .picture((String) payload.get("picture"))
                        .username(payload.getEmail())
                        .name((String) payload.get("name"))
                        .enabled((boolean) payload.get("email_verified"))
                        .build();

            }
        }

        throw new IllegalArgumentException("Token not is valid!");
    }

    @Override
    public ObjectId getUserId() {
        return new ObjectId("602fc1342c37331b84a3af6a");
//        try {
//            var id = findUserByUsernamePort.execute(getUser().getUsername(), User.class).getId();
//            return new ObjectId(id);
//        } catch (GeneralSecurityException | IOException e) {
//            throw new IllegalArgumentException("Token not is valid!");
//        }
    }
}

