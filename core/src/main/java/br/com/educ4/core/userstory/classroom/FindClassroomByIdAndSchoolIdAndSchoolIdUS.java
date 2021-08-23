package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdAndSchoolIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FindClassroomByIdAndSchoolIdAndSchoolIdUS implements FindClassroomByIdAndSchoolIdPort {

    private final ClassroomRepositoryPort repository;

    @Override
    public <T> T execute(String id, ObjectId schoolId, Class<T> projection) {
        return repository.findByIdAndSchoolId(id, schoolId, projection).orElseThrow(() -> new NoSuchElementException("Classroom not found!"));
    }

}
