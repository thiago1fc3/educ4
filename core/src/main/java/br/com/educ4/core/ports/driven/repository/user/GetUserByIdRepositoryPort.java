package br.com.educ4.core.ports.driven.repository.user;

import br.com.educ4.core.domain.User;

public interface GetUserByIdRepositoryPort {
    public User execute(String id);
}
