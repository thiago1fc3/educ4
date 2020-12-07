package br.com.educ4.resources.users.factories;

import br.com.educ4.adapters.users.ExitsUserByUsernameMongoRepository;
import br.com.educ4.adapters.users.SaveUserMongoRepository;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.userstory.user.CreateUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CreateUserPortFactory {

    private final ExitsUserByUsernameMongoRepository exitsUserByUsernameRepository;
    private final SaveUserMongoRepository saveUserRepository;

    @Bean
    public CreateUserPort createUserUS(){
        return new CreateUserUS(exitsUserByUsernameRepository, saveUserRepository);
    }
}
