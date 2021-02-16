package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
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
    public School execute(String schoolId, Set<String> usersIds) {
        var dbSchool = findSchoolByIdlUS.execute(schoolId, School.class);
        dbSchool.addProfessors(usersIds);
        return repository.save(dbSchool);
    }
}
