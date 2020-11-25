package br.com.educ4.core.services;

import br.com.educ4.core.domain.User;

public class WelcomeService {

    public User greeting(String name){
        User user = new User();
        user.name(name);
        return user;
    }

}
