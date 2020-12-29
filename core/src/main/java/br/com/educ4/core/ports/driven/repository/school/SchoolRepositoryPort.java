package br.com.educ4.core.ports.driven.repository.school;

import br.com.educ4.core.domain.School;

import java.util.List;

public interface SchoolRepositoryPort {
    
    School findById(String schoolId);

    School save(School school);

    List<School> findAll();

    List<School> findByInstitutionId(String institutionId);
    
}
