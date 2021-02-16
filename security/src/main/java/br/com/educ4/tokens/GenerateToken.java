package br.com.educ4.tokens;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.time.Instant;
import java.util.Date;

import static java.util.UUID.randomUUID;

public class GenerateToken {

    public static String execute(String id) throws JOSEException {

        var key = new ECKeyGenerator(Curve.P_256).keyID(randomUUID().toString()).generate();

        var header = new JWSHeader.Builder(JWSAlgorithm.ES256)
                .type(JOSEObjectType.JWT)
                .keyID(key.getKeyID())
                .build();

        var payload = new JWTClaimsSet.Builder()
                .issuer(id)
                .audience(id)
                .subject(id)
                .jwtID(randomUUID().toString())
                .claim("p", key.toECPublicKey().getFormat())
                .expirationTime(Date.from(Instant.now().plusSeconds(120)))
                .build();

        var signedJWT = new SignedJWT(header, payload);
        signedJWT.sign(new ECDSASigner(key.toECPrivateKey()));

        return signedJWT.serialize();

    }

}
