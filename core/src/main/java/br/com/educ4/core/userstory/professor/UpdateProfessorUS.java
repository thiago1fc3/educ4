package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorBySchoolIdAndUserIdPort;
import br.com.educ4.core.ports.driver.professor.UpdateProfessorPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProfessorUS implements UpdateProfessorPort {

    private final FindProfessorBySchoolIdAndUserIdPort findProfessorBySchoolIdAndUserIdPort;
    private final ProfessorRepositoryPort repository;

    @Override
    public Professor execute(String schoolId, ObjectId userId, Professor professor) {
        var dbProfessor = findProfessorBySchoolIdAndUserIdPort.execute(schoolId, userId, Professor.class);

        dbProfessor.setRegistration(professor.getRegistration());

        return repository.save(dbProfessor);
    }
}
