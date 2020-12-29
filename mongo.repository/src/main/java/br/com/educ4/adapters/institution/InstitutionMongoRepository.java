package br.com.educ4.adapters.institution;

import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driven.repository.institution.InstitutionRepositoryPort;
import br.com.educ4.repository.InstitutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InstitutionMongoRepository implements InstitutionRepositoryPort {

    private final InstitutionRepository repository;

    @Override
    public Institution findById(String institutionId) {
        return repository.findById(institutionId).orElseThrow(() -> new NoSuchElementException("Institution not found"));
    }

    @Override
    public Institution save(Institution institution) {
        return repository.save(institution);
    }

    @Override
    public List<Institution> findAll() {
        return repository.findAll();
    }
}
