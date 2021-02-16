package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.professor.GetAllProfessorPort;
import br.com.educ4.core.ports.driver.school.GetAllSchoolsPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetAllProfessorsUS implements GetAllProfessorPort {

    private final ProfessorRepositoryPort repository;

    public <T> List<T> execute(Class<T> projection) {
        return repository.findBy(projection);
    }

}
