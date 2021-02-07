package br.com.educ4.tokens;

import io.jsonwebtoken.Jwts;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

import static br.com.educ4.tokens.Keys.salts;
import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.LocalDateTime.now;
import static java.time.ZoneId.systemDefault;
import static java.util.Date.from;

public class GenerateToken {

    private final static SecureRandom secureRandom = new SecureRandom();

    public static String execute(String id, String client) {

        var salt = salts[secureRandom.nextInt(salts.length)];
        var key = hmacShaKeyFor(format("%s%s", salt, client).getBytes(UTF_8));

        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(from(now().plusYears(1).atZone(systemDefault()).toInstant()))
                .setId(UUID.randomUUID().toString())
                .claim("salt", salt)
                .signWith(key)
                .compact();
    }

}
