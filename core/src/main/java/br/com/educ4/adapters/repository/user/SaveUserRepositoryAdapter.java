package br.com.educ4.adapters.repository.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.SaveUserRepositoryPort;

import java.util.Objects;
import java.util.UUID;

public class SaveUserRepositoryAdapter implements SaveUserRepositoryPort {

    @Override
    public User execute(User user) {
        var id = Objects.isNull(user.getId()) ?
                    UUID.randomUUID().toString(): user.getId();

        var localUser = User.builder()
                .id(id)
                .username(user.getUsername())
                .name(user.getName())
                .picture(user.getPicture())
                .build();

        UserDatabase.DATA.put(id, localUser);

        return localUser;
    }
}
