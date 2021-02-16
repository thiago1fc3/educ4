package br.com.educ4.core.userstory.user;

import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.ExistsUserByUsernamePort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ExistsUserByUsernameUS implements ExistsUserByUsernamePort {

    private final UserRepositoryPort repository;

    @Override
    public boolean execute(String username) {
        return repository.existsByUsername(username);
    }
    
}
