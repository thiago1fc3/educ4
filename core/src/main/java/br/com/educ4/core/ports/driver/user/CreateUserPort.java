package br.com.educ4.core.ports.driver.user;

import br.com.educ4.core.domain.User;

public interface CreateUserPort {
    User execute(User user);
}
