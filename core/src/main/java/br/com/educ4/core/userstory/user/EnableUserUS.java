package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.EnableUserPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class EnableUserUS implements EnableUserPort {

    private final UserRepositoryPort repository;
    private final FindUserByIdPort findUserByIdPort;

    @Override
    public User execute(String id, boolean value) {
        var user = findUserByIdPort.execute(id, User.class);
        user.setEnabled(value);
        return repository.save(user);
    }
}
