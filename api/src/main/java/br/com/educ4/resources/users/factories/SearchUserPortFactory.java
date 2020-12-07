package br.com.educ4.resources.users.factories;

import br.com.educ4.adapters.users.FindUserBySearchMongoRepository;
import br.com.educ4.core.ports.driver.user.SearchUserPort;
import br.com.educ4.core.userstory.user.SearchUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SearchUserPortFactory {

    private final FindUserBySearchMongoRepository searchMongoRepository;

    @Bean
    public SearchUserPort searchUserUS(){
        return new SearchUserUS(searchMongoRepository);
    }
}
