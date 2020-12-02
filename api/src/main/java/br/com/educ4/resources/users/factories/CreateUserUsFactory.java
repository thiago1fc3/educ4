package br.com.educ4.resources.users.factories;

import br.com.educ4.adapters.users.ExitsUserByUsernameMongoRepository;
import br.com.educ4.adapters.users.SaveUserMongoRepository;
import br.com.educ4.core.userstory.user.CreateUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CreateUserUsFactory {

    private final ExitsUserByUsernameMongoRepository exitsUserByUsernameRepository;
    private final SaveUserMongoRepository saveUserRepository;

    @Bean
    public CreateUserUS createUserUS(){
        return new CreateUserUS(exitsUserByUsernameRepository, saveUserRepository);
    }
}
