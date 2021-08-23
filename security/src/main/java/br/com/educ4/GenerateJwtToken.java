package br.com.educ4;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.security.GenerateJWTPort;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class GenerateJwtToken implements GenerateJWTPort {

    public String execute(User user, String fingerprint) {

        var index = Keys.randomIndex();

        var header = getJwsHeader(index);

        var payload = getJwtClaimsSet(user);

        var signedJWT = sign(fingerprint, index, header, payload);

        return signedJWT.serialize();

    }

    private JWSHeader getJwsHeader(int index) {
        return new JWSHeader.Builder(JWSAlgorithm.HS256)
                .type(JOSEObjectType.JWT)
                .keyID(String.format("%s", index))
                .build();
    }

    private JWTClaimsSet getJwtClaimsSet(User user) {
        return new JWTClaimsSet.Builder()
                .issuer("https://educ4.com.br")
                .audience("https://educ4.com.br")
                .subject(user.getId())
                .expirationTime(Date.from(Instant.now().plusSeconds(3600)))
                .build();
    }

    private SignedJWT sign(String fingerprint, int index, JWSHeader header, JWTClaimsSet payload) {

        try {

            var signedJWT = new SignedJWT(header, payload);
            signedJWT.sign(new MACSigner(Keys.get(index, fingerprint)));

            return signedJWT;

        } catch (JOSEException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
