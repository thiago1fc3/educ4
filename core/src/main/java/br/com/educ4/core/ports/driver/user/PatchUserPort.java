package br.com.educ4.core.ports.driver.user;

import br.com.educ4.core.domain.User;

public interface PatchUserPort {
    public User execute(String id, User user);
}
