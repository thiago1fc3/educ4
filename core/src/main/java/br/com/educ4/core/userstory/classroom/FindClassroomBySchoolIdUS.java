package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomBySchoolIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClassroomBySchoolIdUS implements FindClassroomBySchoolIdPort {

    private final ClassroomRepositoryPort repository;

    public <T> List<T> execute(ObjectId schoolId, Class<T> projection) {
        return repository.findBySchoolId(schoolId, projection);
    }

}
