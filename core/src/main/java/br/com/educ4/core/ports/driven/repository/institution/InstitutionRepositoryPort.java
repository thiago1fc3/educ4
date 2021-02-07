package br.com.educ4.core.ports.driven.repository.institution;

import br.com.educ4.core.domain.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionRepositoryPort {

    Institution save(Institution institution);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);

}
