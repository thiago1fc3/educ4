package br.com.educ4;

import br.com.educ4.core.ports.driven.security.VerifyJWTPort;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@Named
@RequiredArgsConstructor
public class VerifyJwtToken implements VerifyJWTPort {

    @Override
    public boolean execute(String jwt, String fingerprint) {

        try {
            var token = SignedJWT.parse(jwt);
            var index = token.getHeader().getKeyID();

            if (Objects.isNull(index))
                throw new IllegalStateException("Token not is valid!");

            return token.verify(new MACVerifier(Keys.get(Integer.parseInt(index), fingerprint))) && expired(token);

        } catch (ParseException | JOSEException e) {
            throw new IllegalStateException("Token not is valid!");
        }

    }

    private static boolean expired(SignedJWT token) throws ParseException {
        return token.getJWTClaimsSet().getExpirationTime().after(new Date());
    }

}
