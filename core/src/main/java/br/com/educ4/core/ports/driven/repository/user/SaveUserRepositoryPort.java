package br.com.educ4.core.ports.driven.repository.user;

import br.com.educ4.core.domain.User;

public interface SaveUserRepositoryPort {
    public User execute(User user);
}
