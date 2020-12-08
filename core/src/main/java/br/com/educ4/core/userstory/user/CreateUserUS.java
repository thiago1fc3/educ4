package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.ExitsUserByUsernameRepositoryPort;
import br.com.educ4.core.ports.driven.repository.user.SaveUserRepositoryPort;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.services.user.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUS implements CreateUserPort {

    private final ExitsUserByUsernameRepositoryPort checkIfUsernameExitsUser;
    private final SaveUserRepositoryPort saveUser;

    @Override
    public User execute(User user) {

        UserService.execute(user);

        if(checkIfUsernameExitsUser.execute(user.getUsername()))
            throw new RuntimeException("Usuário já existe");


        return saveUser.execute(user);
    }
}
