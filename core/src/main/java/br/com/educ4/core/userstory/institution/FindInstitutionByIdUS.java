package br.com.educ4.core.userstory.institution;

import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.core.ports.driver.institution.FindInstitutionByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FindInstitutionByIdUS implements FindInstitutionByIdPort {

    private final InstitutionRepositoryPort repository;

    @Override
    public <T> T execute(String id, Class<T> projection) {
        return repository.findById(id, projection).orElseThrow(() -> new NoSuchElementException("Institution not found!"));
    }
}
