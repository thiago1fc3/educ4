package br.com.educ4.core.ports.driven.repository.professor;

import br.com.educ4.core.domain.Professor;

import java.util.List;

public interface ProfessorRepositoryPort {

    Professor findById(String professorId);

    Professor save(Professor professor);

    List<Professor> findAll();

}
