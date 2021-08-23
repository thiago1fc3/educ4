package br.com.educ4.core.userstory.school;

import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.GetSchoolsByInstitutionIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSchoolsByInstitutionIdUS implements GetSchoolsByInstitutionIdPort {

    private final SchoolRepositoryPort repository;

    @Override
    public <T> List<T> execute(ObjectId institutionId, Class<T> projection) {
        return repository.findByInstitutionId(institutionId, projection);
    }
}
