package br.com.educ4.core.ports.driven.security;

public interface VerifyJWTPort {
    boolean execute(String jwt, String fingerprint);
}
