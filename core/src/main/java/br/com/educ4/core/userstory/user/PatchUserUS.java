package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.GetUserByIdRepositoryPort;
import br.com.educ4.core.ports.driven.repository.user.SaveUserRepositoryPort;
import br.com.educ4.core.ports.driver.user.PatchUserPort;
import br.com.educ4.core.services.user.UserService;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Named
@RequiredArgsConstructor
public class PatchUserUS implements PatchUserPort {

    private final GetUserByIdRepositoryPort getUserByIdRepositoryPort;
    private final SaveUserRepositoryPort saveUserRepositoryPort;

    @Override
    public User execute(String id, User user) {
        var oldUser = getUserByIdRepositoryPort.execute(id);

        if(isNull(oldUser))
            throw new RuntimeException("Usuário não existe");

        oldUser = UserService.execute(replace(oldUser, user));

        return saveUserRepositoryPort.execute(oldUser);
    }

    private User replace(User oldUser, User user) {
        if(nonEmpty(user.getName()))
            oldUser.setName(user.getName());

        if(nonEmpty(user.getPicture()))
            oldUser.setPicture(user.getPicture());

        return oldUser;
    }

    private boolean nonEmpty(String value) {
        return nonNull(value) && !value.isBlank();
    }
}
