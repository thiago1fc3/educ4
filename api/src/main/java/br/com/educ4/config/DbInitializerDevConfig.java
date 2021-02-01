package br.com.educ4.config;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbInitializerDevConfig {

    private final CreateUserPort createUserPort;

    @Bean
    public CommandLineRunner dataLoader() {
        return (args -> {
            if (!DbInitializerConstants.DB_INITIALIZED) {
                var user = User.builder()
                        .name("Usuário de Teste")
                        .username("admin@admin.com")
                        .enabled(true)
                        .build();
                createUserPort.execute(user);
            }
        });
    }

}
