package br.com.educ4.core.userstory.institution;

import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.core.ports.driver.institution.PatchInstitutionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatchInstitutionUS implements PatchInstitutionPort {

    private final FindInstitutionByIdUS findInstitutionByIdUS;
    private final InstitutionRepositoryPort repository;

    @Override
    public Institution execute(String institutionId, Institution institution) {
        var dbInstitution = findInstitutionByIdUS.execute(institutionId, Institution.class);

//        getMapper().map(institution, dbInstitution);

        return repository.save(dbInstitution);
    }
}
