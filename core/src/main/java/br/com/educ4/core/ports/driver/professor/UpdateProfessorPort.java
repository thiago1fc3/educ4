package br.com.educ4.core.ports.driver.professor;

import br.com.educ4.core.domain.Professor;

public interface UpdateProfessorPort {

    Professor execute(String schoolId, String userId, Professor professor);

}
