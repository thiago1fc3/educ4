package br.com.educ4.core.userstory.institution;

import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.core.ports.driver.institution.FindInstitutionByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class FindInstitutionByIdUS implements FindInstitutionByIdPort {

    private final InstitutionRepositoryPort repository;

    public Institution execute(String id) {
        return repository.findById(id);
    }

}
