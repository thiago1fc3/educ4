package br.com.educ4;

import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequiredArgsConstructor
public class AuthUser {

    private final HttpServletRequest request;

    public String getId() {
        return "id";
    }
//
//    private Jws<Claims> getClaimsJws() {
//        var authorizationHeader = request.getHeader("Authorization");
//        var key = request.getHeader("key");
//        var token = authorizationHeader.substring("Bearer".length()).trim();
//
//
//
//        return jws;
//    }
}
