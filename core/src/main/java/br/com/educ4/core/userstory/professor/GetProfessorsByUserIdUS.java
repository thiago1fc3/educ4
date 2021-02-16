package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.GetProfessorsByUserIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetProfessorsByUserIdUS implements GetProfessorsByUserIdPort {

    private final ProfessorRepositoryPort repository;

    @Override
    public <T> List<T> execute(String userId, Class<T> projection) {
        return repository.findByUserId(userId, projection);
    }
}
