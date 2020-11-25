package br.com.educ4.core.userstory;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.WelcomePort;
import br.com.educ4.core.services.WelcomeService;

public class WelcomeUS implements WelcomePort {

    private WelcomeService welcomeService = new WelcomeService();

    @Override
    public String greeting(String name) {
        User user =  welcomeService.greeting(name);
        return String.format("Olá, %s", user.name());
    }
}
