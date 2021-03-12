package br.com.educ4.core.ports.driver.classroom;

import org.bson.types.ObjectId;

public interface AddStudentToClassroomPort {

    void execute(String classroomId, ObjectId studentId);

}
