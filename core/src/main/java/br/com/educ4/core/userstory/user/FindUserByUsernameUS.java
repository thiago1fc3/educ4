package br.com.educ4.core.userstory.user;

import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FindUserByUsernameUS implements FindUserByUsernamePort {

    private final UserRepositoryPort repository;

    @Override
    public <T> T execute(String username, Class<T> projection) {
        return repository.findByUsername(username, projection).orElseThrow(() -> new NoSuchElementException("User not found."));
    }

}
