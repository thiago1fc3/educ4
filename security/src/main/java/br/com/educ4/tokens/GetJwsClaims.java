//package br.com.educ4.tokens;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.SignatureException;
//
//import static br.com.educ4.tokens.Keys.salts;
//import static io.jsonwebtoken.Jwts.parserBuilder;
//import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;
//import static java.lang.String.format;
//import static java.nio.charset.StandardCharsets.UTF_8;
//
//public class GetJwsClaims {
//
//    public static Jws<Claims> execute(int salt, String client, String token) {
//
//        var key = hmacShaKeyFor(format("%s%s", salts[salt], client).getBytes(UTF_8));
//
//        try {
//            return parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token);
//
//        } catch (ExpiredJwtException ex) {
//            throw new IllegalStateException("Token expirado!");
//        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException ex) {
//            throw new IllegalStateException("Token inválido!");
//        }
//
//    }
//
//}
