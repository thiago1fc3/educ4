package br.com.educ4.core.ports.driver.user;

import br.com.educ4.core.domain.User;

import java.util.List;

public interface SearchUserPort {
    public List<User> execute(String q);
}
