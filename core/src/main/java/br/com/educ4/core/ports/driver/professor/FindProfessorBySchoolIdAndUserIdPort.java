package br.com.educ4.core.ports.driver.professor;

import org.bson.types.ObjectId;

public interface FindProfessorBySchoolIdAndUserIdPort {
    <T> T execute(String schoolId, ObjectId userId, Class<T> projection);
}
