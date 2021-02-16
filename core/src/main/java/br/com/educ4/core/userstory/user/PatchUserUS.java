package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import br.com.educ4.core.ports.driver.user.PatchUserPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static java.util.Objects.nonNull;

@Named
@RequiredArgsConstructor
public class PatchUserUS implements PatchUserPort {

    private final UserRepositoryPort repository;
    private final FindUserByIdPort findUserByIdPort;

    @Override
    public User execute(String id, User user) {
        var oldUser = findUserByIdPort.execute(id, User.class);

        oldUser = replace(oldUser, user);

        return repository.save(oldUser);
    }

    private User replace(User oldUser, User user) {
        if (nonEmpty(user.getName()))
            oldUser.setName(user.getName());

        if (nonEmpty(user.getPicture()))
            oldUser.setPicture(user.getPicture());

        return oldUser;
    }

    private boolean nonEmpty(String value) {
        return nonNull(value) && !value.isBlank();
    }
}
