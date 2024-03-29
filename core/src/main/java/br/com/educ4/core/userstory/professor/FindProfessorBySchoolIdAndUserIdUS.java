package br.com.educ4.core.userstory.professor;

import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorBySchoolIdAndUserIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FindProfessorBySchoolIdAndUserIdUS implements FindProfessorBySchoolIdAndUserIdPort {

    private final ProfessorRepositoryPort repository;

    @Override
    public <T> T execute(String schoolId, ObjectId userId, Class<T> projection) {
        return repository.findBySchoolIdAndUserId(schoolId, userId, projection).orElseThrow(() -> new NoSuchElementException("Professor not found!"));
    }
}
