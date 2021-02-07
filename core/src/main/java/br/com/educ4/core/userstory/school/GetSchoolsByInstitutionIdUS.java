package br.com.educ4.core.userstory.school;

import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.GetSchoolsByInstitutionIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetSchoolsByInstitutionIdUS implements GetSchoolsByInstitutionIdPort {

    private final SchoolRepositoryPort repository;

    @Override
    public <T> List<T> execute(String institutionId, Class<T> projection) {
        return repository.findByInstitutionId(institutionId, projection);
    }
}
