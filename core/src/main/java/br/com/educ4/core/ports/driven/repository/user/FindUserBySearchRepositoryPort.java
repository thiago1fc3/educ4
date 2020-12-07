package br.com.educ4.core.ports.driven.repository.user;

import br.com.educ4.core.domain.User;

import java.util.List;

public interface FindUserBySearchRepositoryPort {
    // TODO Realizar busca paginada
    public List<User> execute(String q);
}
