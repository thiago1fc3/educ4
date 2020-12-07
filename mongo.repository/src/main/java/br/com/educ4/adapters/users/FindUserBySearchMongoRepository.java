package br.com.educ4.adapters.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.FindUserBySearchRepositoryPort;
import br.com.educ4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindUserBySearchMongoRepository implements FindUserBySearchRepositoryPort {

    private final UserRepository repository;

    @Override
    public List<User> execute(String q) {
        return repository.findBySearch(q);
    }
}
