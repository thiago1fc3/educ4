package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByStudentsIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClassroomByStudentsIdUS implements FindClassroomByStudentsIdPort {

    private final ClassroomRepositoryPort repository;

    public <T> List<T> execute(ObjectId studentId, Class<T> projection) {
        return repository.findByStudents(studentId, projection);
    }

}
