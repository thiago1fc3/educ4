package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.ExitsProfessorBySchoolIdAndUserIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ExistsProfessorBySchoolIdAndUserIdUS implements ExitsProfessorBySchoolIdAndUserIdPort {

    private final ProfessorRepositoryPort repository;

    @Override
    public boolean execute(String schoolId, String userId) {
        return repository.existsBySchoolIdAndUserId(schoolId, userId);
    }
}
