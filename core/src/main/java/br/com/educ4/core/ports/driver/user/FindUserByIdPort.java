package br.com.educ4.core.ports.driver.user;

public interface FindUserByIdPort {
    <T> T execute(String id, Class<T> projection);
}
