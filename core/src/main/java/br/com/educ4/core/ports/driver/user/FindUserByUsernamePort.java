package br.com.educ4.core.ports.driver.user;

public interface FindUserByUsernamePort {
    <T> T execute(String username, Class<T> projection);
}
