package br.com.educ4.adapters.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.FindByIdSchoolRepositoryPort;
import br.com.educ4.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FindByIdMongoRepository implements FindByIdSchoolRepositoryPort {

    private final SchoolRepository repository;

    @Override
    public School execute(String schoolId) {
        return repository.findById(schoolId).orElseThrow(() -> new NoSuchElementException("School not found"));
    }
    
}
