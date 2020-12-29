package br.com.educ4.core.ports.driven.repository.institution;

import br.com.educ4.core.domain.Institution;

import java.util.List;

public interface InstitutionRepositoryPort {

    Institution findById(String institutionId);

    Institution save(Institution institution);

    List<Institution> findAll();

}
