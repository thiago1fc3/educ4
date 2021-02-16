package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.PatchSchoolPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static br.com.educ4.core.utils.MapperConfig.getMapper;

@Named
@RequiredArgsConstructor
public class PatchSchoolUS implements PatchSchoolPort {

    private final FindSchoolByIdUS findSchoolByIdlUS;
    private final SchoolRepositoryPort repository;

    public School execute(String schoolId, School school) {

        var dbSchool = findSchoolByIdlUS.execute(schoolId, School.class);

        getMapper().map(school, dbSchool);

        return repository.save(dbSchool);
    }
}
