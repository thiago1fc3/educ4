package br.com.educ4.resources.school.factories;

import br.com.educ4.adapters.school.SaveSchoolMongoRepository;
import br.com.educ4.core.ports.driven.repository.school.SaveSchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.core.userstory.school.CreateSchoolUS;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor

public class CreateSchoolPortFactory {
    private final SaveSchoolMongoRepository saveSchoolRepositoryPort;
    @Bean
    public CreateSchoolPort createSchoolPort() {
        return new CreateSchoolUS(saveSchoolRepositoryPort);
    }
}
