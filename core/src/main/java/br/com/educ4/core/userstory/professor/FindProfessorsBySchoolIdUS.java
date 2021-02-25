package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.ports.driven.repository.professor.FindProfessorBySchoolIdRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorsBySchoolIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class FindProfessorsBySchoolIdUS implements FindProfessorsBySchoolIdPort {

    private final FindProfessorBySchoolIdRepositoryPort repository;

    @Override
    public <T> List<T> execute(ObjectId schoolId, Class<T> projection) {
        return repository.findBySchoolId(schoolId, projection);
    }
}
