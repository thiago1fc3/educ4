package br.com.educ4.core.ports.driven.repository.user;

import br.com.educ4.core.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepositoryPort {

    User save(User user);

    <T> Optional<T> findById(String id, Class<T> projection);

    boolean existsByUsername(String username);

    <T> Optional<T> findByUsername(String username, Class<T> projection);

    <T> Set<T> findByIdIn(Set<String> ids, Class<T> projection);

}
