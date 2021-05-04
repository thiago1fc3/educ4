package br.com.educ4.core.ports.driver.professor;

import org.bson.types.ObjectId;

import java.util.List;

public interface FindProfessorsBySchoolIdPort {
    <T> List<T> execute(ObjectId schoolId, Class<T> projection);
}
