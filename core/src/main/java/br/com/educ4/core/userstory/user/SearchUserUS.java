package br.com.educ4.core.userstory.user;

import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.SearchUserPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class SearchUserUS implements SearchUserPort {

    private final UserRepositoryPort repository;

    @Override
    public <T> List<T> execute(String q, Class<T> projection) {
        return repository.findBySearch(q, projection);
    }
}
