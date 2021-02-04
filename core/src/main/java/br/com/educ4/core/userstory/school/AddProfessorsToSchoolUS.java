package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.AddCoordinatorsToSchoolPort;
import br.com.educ4.core.ports.driver.school.AddProfessorsToSchoolPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.Set;

@Named
@RequiredArgsConstructor
public class AddProfessorsToSchoolUS implements AddProfessorsToSchoolPort {

    private final FindSchoolByIdUS findSchoolByIdlUS;
    private final SchoolRepositoryPort repository;

    @Override
    public School execute(String schoolId, Set<String> professorsIds) {
        var dbSchool = findSchoolByIdlUS.execute(schoolId);
        dbSchool.addProfessors(professorsIds);
        return repository.save(dbSchool);
    }
}
