package br.com.educ4.core.ports.driven.repository.school;

import br.com.educ4.core.domain.School;

import java.util.List;
import java.util.Optional;

public interface SchoolRepositoryPort {

    School save(School school);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);

    <T> List<T> findByInstitutionId(String institutionId, Class<T> projection);

}
