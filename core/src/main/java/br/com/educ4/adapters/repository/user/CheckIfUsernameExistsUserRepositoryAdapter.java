package br.com.educ4.adapters.repository.user;

import br.com.educ4.core.ports.driven.repository.user.CheckIfUsernameExitsUserRepositoryPort;

public class CheckIfUsernameExistsUserRepositoryAdapter implements CheckIfUsernameExitsUserRepositoryPort {

    @Override
    public boolean execute(String username) {

        for (var user : UserDatabase.DATA.values()){
            if(user.getUsername().equals(username))
                return true;
        }

        return false;
    }
}
