package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorsBySchoolIdPort;
import br.com.educ4.core.ports.driver.school.FindSchoolByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toSet;

@Named
@RequiredArgsConstructor
public class FindProfessorsBySchoolIdUS implements FindProfessorsBySchoolIdPort {

    private final FindSchoolByIdPort findSchoolByIdPort;
    private final UserRepositoryPort userRepositoryPort;
    private final ProfessorRepositoryPort professorRepositoryPort;

    @Override
    public <T> List<T> execute(String schoolId, Class<T> projection) {
        var school = findSchoolByIdPort.execute(schoolId, School.class);
        // System.out.printf(">>>>>>>>>>>>>>" + school.getProfessorsIds());
        // var professors = professorRepositoryPort.findByIdIn(school.getProfessorsIds(), Professor.class);
        // var userIds = professors.stream().map(p -> p.getUserId()).collect(toSet());
        // System.out.printf(">>>>>>>>>>>>>>" + professors);

        if (!school.getProfessorsIds().isEmpty()) {
            return userRepositoryPort.findByIdIn(school.getProfessorsIds(), projection);
        }
        return new ArrayList<>();
    }
}
