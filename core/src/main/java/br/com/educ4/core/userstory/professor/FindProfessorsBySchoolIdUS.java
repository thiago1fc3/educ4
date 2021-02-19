package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorsBySchoolIdPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdInPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Named
@RequiredArgsConstructor
public class FindProfessorsBySchoolIdUS implements FindProfessorsBySchoolIdPort {

    private final ProfessorRepositoryPort repository;
    private final FindUserByIdInPort findUserByIdInPort;

    @Override
    public <T> Set<T> execute(String schoolId, Class<T> projection) {
        var professors = repository.findBySchoolId(schoolId, Professor.class);
        var userIds = professors.stream().map(p -> p.getUserId()).collect(toSet());

        return findUserByIdInPort.execute(userIds, projection);
    }
}
