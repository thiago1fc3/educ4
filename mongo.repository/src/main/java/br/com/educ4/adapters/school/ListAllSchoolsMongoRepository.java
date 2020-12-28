package br.com.educ4.adapters.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.ListAllSchoolsRepositoryPort;
import br.com.educ4.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListAllSchoolsMongoRepository implements ListAllSchoolsRepositoryPort {

    private final SchoolRepository repository;

    @Override
    public List<School> execute() {
        return repository.findAll();
    }
}
