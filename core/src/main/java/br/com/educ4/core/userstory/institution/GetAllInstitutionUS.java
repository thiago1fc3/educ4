package br.com.educ4.core.userstory.institution;

import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.core.ports.driver.institution.GetAllInstitutionsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllInstitutionUS implements GetAllInstitutionsPort {

    private final InstitutionRepositoryPort repository;

    @Override
    public <T> List<T> execute(Class<T> projection) {
        return repository.findBy(projection);
    }
}
