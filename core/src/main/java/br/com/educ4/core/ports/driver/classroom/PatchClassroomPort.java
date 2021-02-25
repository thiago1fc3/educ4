package br.com.educ4.core.ports.driver.classroom;

import br.com.educ4.core.domain.Classroom;
import org.bson.types.ObjectId;

public interface PatchClassroomPort {

    Classroom execute(String classroomId, ObjectId schoolId, Classroom classroom);

}
