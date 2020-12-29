package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.core.services.school.SchoolService;
import br.com.educ4.core.userstory.institution.FindInstitutionByIdUS;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateSchoolUS implements CreateSchoolPort {
    private final SchoolRepositoryPort repository;
    private final FindInstitutionByIdUS findInstitutionByIdUS;

    @Override
    public School execute(String institutionId, School school) {
        var institution = findInstitutionByIdUS.execute(institutionId);

        school.setInstitutionId(institution.getId());

        SchoolService.execute(school);
        return repository.save(school);
    }
}
