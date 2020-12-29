package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.core.services.school.SchoolService;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateSchoolUS implements CreateSchoolPort {
    private final SchoolRepositoryPort repository;

    @Override
    public School execute(School school) {
        SchoolService.execute(school);
        return repository.save(school);
    }
}
