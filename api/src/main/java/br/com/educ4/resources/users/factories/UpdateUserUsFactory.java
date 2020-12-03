package br.com.educ4.resources.users.factories;

import br.com.educ4.adapters.users.ExitsUserByUsernameMongoRepository;
import br.com.educ4.adapters.users.GetUserByIdMongoRepository;
import br.com.educ4.adapters.users.SaveUserMongoRepository;
import br.com.educ4.core.ports.driven.repository.user.GetUserByIdRepositoryPort;
import br.com.educ4.core.userstory.user.CreateUserUS;
import br.com.educ4.core.userstory.user.UpdateUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UpdateUserUsFactory {

    private final GetUserByIdMongoRepository getUserByIdRepositoryPort;
    private final SaveUserMongoRepository saveUserRepository;

    @Bean
    public UpdateUserUS updateUserUS(){
        return new UpdateUserUS(getUserByIdRepositoryPort, saveUserRepository);
    }
}
