package br.com.educ4.core.ports.driver.professor;

import br.com.educ4.core.domain.Professor;
import org.bson.types.ObjectId;

public interface UpdateProfessorPort {

    Professor execute(String schoolId, ObjectId userId, Professor professor);

}
