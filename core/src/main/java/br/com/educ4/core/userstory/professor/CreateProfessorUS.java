package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.CreateProfessorPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateProfessorUS implements CreateProfessorPort {

    private final ProfessorRepositoryPort repository;

    public Professor execute(Professor professor) {
        return repository.save(professor);
    }

}
