package br.com.educ4.core.ports.driver.auth;

public interface LoginByGooglePort {
    String execute(String token, String fingerprint);
}
