package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SaveSchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.PatchSchoolPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class PatchSchoolUS implements PatchSchoolPort {

    private final FindByIdSchoolUS findByIdSchoolUS;
    private final SaveSchoolRepositoryPort saveSchoolRepositoryPort;

    public School execute(String schoolId, School school) {

        var dbSchool = findByIdSchoolUS.execute(schoolId);
        dbSchool.setName(school.getName());

        return saveSchoolRepositoryPort.execute(dbSchool);
    }
}
