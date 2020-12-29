package br.com.educ4.adapters.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SchoolMongoRepository implements SchoolRepositoryPort {

    private final SchoolRepository repository;

    @Override
    public School findById(String schoolId) {
        return repository.findById(schoolId).orElseThrow(() -> new NoSuchElementException("School not found"));
    }

    @Override
    public School save(School school) {
        return repository.save(school);
    }

    @Override
    public List<School> findAll() {
        return repository.findAll();
    }

    @Override
    public List<School> findByInstitutionId(String institutionId) {
        return repository.findByInstitutionId(institutionId);
    }
}
