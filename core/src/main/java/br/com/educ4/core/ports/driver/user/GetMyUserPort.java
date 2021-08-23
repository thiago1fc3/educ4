package br.com.educ4.core.ports.driver.user;

public interface GetMyUserPort {

    <T> T execute(String userId, Class<T> projection);

}
