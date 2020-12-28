package br.com.educ4.core.ports.driven.repository.classroom;

import br.com.educ4.core.domain.Classroom;

import java.util.List;

public interface ClassroomRepositoryPort {

    Classroom findById(String classroomId);

    Classroom save(Classroom classroom);

    List<Classroom> findAll();

}
