package br.com.educ4.adapters.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SaveSchoolRepositoryPort;
import br.com.educ4.entities.SchoolDocument;
import br.com.educ4.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveSchoolMongoRepository implements SaveSchoolRepositoryPort {

    private final SchoolRepository repository;

    @Override
    public School execute(School school) {

        var document = SchoolDocument.fromSchool(school);
        document = repository.save(document);

        return document.toSchool(school);
    }
}
