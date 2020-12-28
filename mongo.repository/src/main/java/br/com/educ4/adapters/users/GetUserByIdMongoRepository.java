package br.com.educ4.adapters.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.GetUserByIdRepositoryPort;
import br.com.educ4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetUserByIdMongoRepository implements GetUserByIdRepositoryPort {

    private final UserRepository repository;

    @Override
    public User execute(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
    }
}
