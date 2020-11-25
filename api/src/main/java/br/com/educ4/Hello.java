package br.com.educ4;

import br.com.educ4.core.ports.driver.WelcomePort;
import br.com.educ4.core.userstory.WelcomeUS;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Hello {

    private WelcomePort welcomePort = new WelcomeUS();

    @GetMapping
    public String get(){
        return  welcomePort.greeting("Hello");
    }
}
