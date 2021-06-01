package br.com.educ4;

import br.com.educ4.core.ports.driven.security.AuthUserIdPort;
import br.com.educ4.core.ports.driven.security.VerifyJWTPort;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHeaders;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Objects;

@Named
@RequiredArgsConstructor
public class AuthUserId implements AuthUserIdPort {

    private final HttpServletRequest http;
    private final VerifyJWTPort verifyJWTPort;

    @Override
    public String getUserId() {

        var jwt = getJtw();

        var userAgent = http.getHeader(HttpHeaders.USER_AGENT);

        var isValid = verifyJWTPort.execute(jwt, userAgent);

        if (!isValid)
            throw new IllegalArgumentException("Token not is valid!");

        try {
            var token = SignedJWT.parse(jwt);
            return token.getJWTClaimsSet().getSubject();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Token not is valid!");
        }

    }

    private String getJtw() {

        var authorizationHeader = http.getHeader(HttpHeaders.AUTHORIZATION);
        if (Objects.isNull(authorizationHeader))
            throw new IllegalArgumentException("Token not is valid!");

        return authorizationHeader.substring("Bearer".length()).trim();

    }

}
