package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorBySchoolIdAndUserIdPort;
import br.com.educ4.core.ports.driver.professor.UpdateProfessorPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class UpdateProfessorUS implements UpdateProfessorPort {

    private final FindProfessorBySchoolIdAndUserIdPort findProfessorBySchoolIdAndUserIdPort;
    private final ProfessorRepositoryPort repository;

    @Override
    public Professor execute(String schoolId, String userId, Professor professor) {
        var dbProfessor = findProfessorBySchoolIdAndUserIdPort.execute(schoolId, userId, Professor.class);

        dbProfessor.setRegistration(professor.getRegistration());

        return repository.save(dbProfessor);
    }
}
