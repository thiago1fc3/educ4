package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.GetUserByIdRepositoryPort;
import br.com.educ4.core.ports.driven.repository.user.SaveUserRepositoryPort;
import br.com.educ4.core.ports.driver.user.UpdateUserPort;
import br.com.educ4.core.services.user.UserService;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class UpdateUserUS implements UpdateUserPort {

    private final GetUserByIdRepositoryPort getUserByIdRepositoryPort;
    private final SaveUserRepositoryPort saveUserRepositoryPort;

    @Override
    public User execute(String id, User user) {

        var oldUser = getUserByIdRepositoryPort.execute(id);

        if(Objects.isNull(oldUser))
            throw new RuntimeException("Usuário não existe");

        if(!oldUser.getId().equals(user.getId()))
            throw new RuntimeException("Você não tem permissão para alterar este usuário");

        UserService.execute(user);

        return saveUserRepositoryPort.execute(user);
    }
}
