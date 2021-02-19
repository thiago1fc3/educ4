package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorBySchoolIdAndUserIdPort;
import br.com.educ4.core.ports.driver.professor.CreateProfessorPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateProfessorUS implements CreateProfessorPort {

    private final ExistsProfessorBySchoolIdAndUserIdUS existsProfessorBySchoolIdAndUserIdUS;
    private final FindProfessorBySchoolIdAndUserIdPort findProfessorBySchoolIdAndUserIdPort;
    private final ProfessorRepositoryPort repository;

    @Override
    public Professor execute(String schoolId, Professor professor) {
        var exists = existsProfessorBySchoolIdAndUserIdUS.execute(schoolId, professor.getUserId());

        if (!exists) {
            professor.setSchoolId(schoolId);
            return repository.save(professor);
        }

        return findProfessorBySchoolIdAndUserIdPort.execute(schoolId, professor.getUserId(), Professor.class);
    }
}
