package br.com.educ4.adapters.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.GetUserByIdRepositoryPort;
import br.com.educ4.entities.UserDocument;
import br.com.educ4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserByIdMongoRepository implements GetUserByIdRepositoryPort {

    private final UserRepository repository;

    @Override
    public User execute(String id) {
        var user = repository.findById(id)
                .orElse(UserDocument.builder().build());

        // TODO refatorar esse código
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .picture(user.getPicture())
                .build();
    }
}
