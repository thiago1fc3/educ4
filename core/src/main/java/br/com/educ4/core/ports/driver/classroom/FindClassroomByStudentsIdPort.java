package br.com.educ4.core.ports.driver.classroom;

import org.bson.types.ObjectId;

import java.util.List;

public interface FindClassroomByStudentsIdPort {

    <T> List<T> execute(ObjectId studentId, Class<T> projection);

}
