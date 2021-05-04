package br.com.educ4.core.ports.driver.week;

import org.bson.types.ObjectId;

import java.util.List;

public interface GetWeeksByClassroomIdPort {

    <T> List<T> execute(ObjectId classroomId, Class<T> projection);

}
