package br.com.educ4.core.ports.driver.professor;

import org.bson.types.ObjectId;

public interface ExitsProfessorBySchoolIdAndUserIdPort {
    boolean execute(String schoolId, ObjectId userId);
}
