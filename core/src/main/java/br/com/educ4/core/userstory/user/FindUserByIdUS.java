package br.com.educ4.core.userstory.user;

import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.NoSuchElementException;

@Named
@RequiredArgsConstructor
public class FindUserByIdUS implements FindUserByIdPort {

    private final UserRepositoryPort repository;

    @Override
    public <T> T execute(String id, Class<T> projection) {
        return repository.findById(id, projection).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado!"));
    }
}
