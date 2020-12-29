package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.PatchSchoolPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class PatchSchoolUS implements PatchSchoolPort {

    private final FindSchoolByIdUS findSchoolByIdlUS;
    private final SchoolRepositoryPort repository;

    public School execute(String schoolId, School school) {

        var dbSchool = findSchoolByIdlUS.execute(schoolId);
        dbSchool.setName(school.getName());

        return repository.save(dbSchool);
    }
}
