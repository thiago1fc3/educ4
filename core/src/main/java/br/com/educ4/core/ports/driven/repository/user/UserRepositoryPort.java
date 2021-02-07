package br.com.educ4.core.ports.driven.repository.user;

import br.com.educ4.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    <T> Optional<T> findById(String id, Class<T> projection);

    boolean existsByUsername(String username);

    <T> Optional<T> findByUsername(String username, Class<T> projection);

    <T> List<T> findBySearch(String q, Class<T> projection);

}
