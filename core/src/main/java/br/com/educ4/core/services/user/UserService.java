package br.com.educ4.core.services.user;

import br.com.educ4.core.domain.User;

import java.util.Objects;

public class UserService {

    public static User execute(User user){

        if(Objects.isNull(user.getUsername()))
            throw new RuntimeException("O atributo username é obrigatório!");

        if(user.getUsername().isBlank())
            throw new RuntimeException("O atributo username é obrigatório!");

        return user;
    }
}
