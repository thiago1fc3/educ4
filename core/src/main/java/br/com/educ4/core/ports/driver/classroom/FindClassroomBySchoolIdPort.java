package br.com.educ4.core.ports.driver.classroom;

import org.bson.types.ObjectId;

import java.util.List;

public interface FindClassroomBySchoolIdPort {

    <T> List<T> execute(ObjectId schoolId, Class<T> projection);

}
