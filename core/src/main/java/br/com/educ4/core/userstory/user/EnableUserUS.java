package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.GetUserByIdRepositoryPort;
import br.com.educ4.core.ports.driven.repository.user.SaveUserRepositoryPort;
import br.com.educ4.core.ports.driver.user.EnableUserPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EnableUserUS implements EnableUserPort {

    private final GetUserByIdRepositoryPort getUserByIdRepositoryPort;
    private final SaveUserRepositoryPort saveUserRepositoryPort;

    @Override
    public User execute(String id, boolean value) {
        var user = getUserByIdRepositoryPort.execute(id);
        user.setEnabled(value);
        return saveUserRepositoryPort.execute(user);
    }
}
