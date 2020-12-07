package br.com.educ4.core.ports.driver.user;

import br.com.educ4.core.domain.User;

public interface EnableUserPort {
    public User execute(String id, boolean value);
}
