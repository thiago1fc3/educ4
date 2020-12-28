package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SaveSchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.core.services.school.SchoolService;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateSchoolUS implements CreateSchoolPort {
    private final SaveSchoolRepositoryPort saveSchoolRepositoryPort;

    @Override
    public School execute(School school) {

        SchoolService.execute(school);

        return saveSchoolRepositoryPort.execute(school);
    }
}
