package br.com.educ4.core.ports.driven.repository.classroom;

import br.com.educ4.core.domain.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepositoryPort {

    Classroom save(Classroom classroom);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);

}
