package br.com.educ4.resources.users.factories;

import br.com.educ4.adapters.users.GetUserByIdMongoRepository;
import br.com.educ4.adapters.users.SaveUserMongoRepository;
import br.com.educ4.core.ports.driver.user.PatchUserPort;
import br.com.educ4.core.userstory.user.PatchUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PatchUserPortFactory {

    private final GetUserByIdMongoRepository getUserByIdRepositoryPort;
    private final SaveUserMongoRepository saveUserRepository;

    @Bean
    public PatchUserPort patchUserUS(){
        return new PatchUserUS(getUserByIdRepositoryPort, saveUserRepository);
    }
}
