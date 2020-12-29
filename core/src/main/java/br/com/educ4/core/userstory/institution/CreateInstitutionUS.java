package br.com.educ4.core.userstory.institution;

import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.core.ports.driver.institution.CreateInstitutionPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateInstitutionUS implements CreateInstitutionPort {
    private final InstitutionRepositoryPort repository;

    @Override
    public Institution execute(Institution institution) {
        return repository.save(institution);
    }
}
