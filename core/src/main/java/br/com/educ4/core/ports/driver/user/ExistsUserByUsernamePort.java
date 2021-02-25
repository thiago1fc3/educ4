package br.com.educ4.core.ports.driver.user;

public interface ExistsUserByUsernamePort {
    public boolean execute(String username);
}
