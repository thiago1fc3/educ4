package br.com.educ4.adapters.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.SaveUserRepositoryPort;
import br.com.educ4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveUserMongoRepository implements SaveUserRepositoryPort {

    private final UserRepository repository;

    @Override
    public User execute(User user) {
        return repository.save(user);
    }
}
