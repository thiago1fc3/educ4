package br.com.educ4.core.userstory.institution;

import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.core.ports.driver.institution.GetAllInstitutionsPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetAllInstitutionUS implements GetAllInstitutionsPort {

    private final InstitutionRepositoryPort repository;

    public List<Institution> execute() {
        return repository.findAll();
    }

}
