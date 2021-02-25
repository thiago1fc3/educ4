package br.com.educ4.core.ports.driver.classroom;

import org.bson.types.ObjectId;

public interface FindClassroomByIdAndSchoolIdPort {

    <T> T execute(String id, ObjectId schoolId, Class<T> projection);

}
