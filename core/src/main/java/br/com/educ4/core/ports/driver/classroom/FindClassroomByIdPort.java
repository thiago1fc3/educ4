package br.com.educ4.core.ports.driver.classroom;

import org.bson.types.ObjectId;

public interface FindClassroomByIdPort {

    <T> T execute(String id, Class<T> projection);

}
