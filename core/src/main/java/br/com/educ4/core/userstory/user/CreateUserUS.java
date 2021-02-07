package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateUserUS implements CreateUserPort {

    private final UserRepositoryPort repository;

    @Override
    public User execute(User user) {

        if (repository.existsByUsername(user.getUsername()))
            throw new IllegalStateException("Usuário já existe");

        return repository.save(user);

    }
}
