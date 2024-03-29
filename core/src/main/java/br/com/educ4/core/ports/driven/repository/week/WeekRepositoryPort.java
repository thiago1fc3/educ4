package br.com.educ4.core.ports.driven.repository.week;

import br.com.educ4.core.domain.Week;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface WeekRepositoryPort {

    Week save(Week week);

    <S extends Week> List<S> saveAll(Iterable<S> iterable);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);

    <T> List<T> findByClassroomId(ObjectId classroomId, Class<T> projection);
}
