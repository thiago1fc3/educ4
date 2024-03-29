package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.GetAllProfessorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProfessorsUS implements GetAllProfessorPort {

    private final ProfessorRepositoryPort repository;

    public <T> List<T> execute(Class<T> projection) {
        return repository.findBy(projection);
    }

}
