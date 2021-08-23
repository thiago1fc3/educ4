package br.com.educ4.core.ports.driven.security;

public interface AuthUserIdPort {

    String getUserId(String jwt, String fingerprint);

}
