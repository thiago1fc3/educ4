package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.GetSchoolsByInstitutionIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetSchoolsByInstitutionIdUS implements GetSchoolsByInstitutionIdPort {

    private final SchoolRepositoryPort repository;

    public List<School> execute(String institutionId) {
        return repository.findByInstitutionId(institutionId);
    }

}
