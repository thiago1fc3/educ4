package br.com.educ4.core.ports.driver.classroom;

import org.bson.types.ObjectId;

public interface AddStudentToClassroom {

    void execute(String classroomId, ObjectId studentId);

}
