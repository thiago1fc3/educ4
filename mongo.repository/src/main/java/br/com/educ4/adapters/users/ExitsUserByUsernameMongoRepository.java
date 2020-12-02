package br.com.educ4.adapters.users;

import br.com.educ4.core.ports.driven.repository.user.ExitsUserByUsernameRepositoryPort;
import br.com.educ4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExitsUserByUsernameMongoRepository implements ExitsUserByUsernameRepositoryPort {

    private final UserRepository repository;

    @Override
    public boolean execute(String username) {
        return repository.existsByUsername(username);
    }
}
