package br.com.educ4.core.ports.driver.professor;

import br.com.educ4.core.domain.Professor;

public interface CreateProfessorPort {

    Professor execute(String schoolId, Professor professor);

}
