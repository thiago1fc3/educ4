package br.com.educ4.core.userstory.user;

import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class FindUserByIdInUS implements FindUserByIdInPort {

    private final UserRepositoryPort repository;

    @Override
    public <T> Set<T> execute(Set<String> ids, Class<T> projection) {
        return repository.findByIdIn(ids, projection);
    }
}
