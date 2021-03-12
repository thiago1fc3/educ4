package br.com.educ4.core.ports.driven.repository.classroom;

import br.com.educ4.core.domain.Classroom;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepositoryPort {

    Classroom save(Classroom classroom);

    <T> Optional<T> findByIdAndSchoolId(String id, ObjectId schoolId, Class<T> projection);

    <T> List<T> findBySchoolId(ObjectId schoolId, Class<T> projection);

    <T> List<T> findByStudents(ObjectId studentId, Class<T> projection);

    <T> T findById(String id, Class<T> projection);

}
