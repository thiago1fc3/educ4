package br.com.educ4.core.ports.driven.repository.professor;

import br.com.educ4.core.domain.Professor;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProfessorRepositoryPort {

    Professor save(Professor professor);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);

    <T> List<T> findByUserId(String userId, Class<T> projection);

    boolean existsBySchoolIdAndUserId(String schoolId, String userId);

    <T> Optional<T> findBySchoolIdAndUserId(String schoolId, String id, Class<T> projection);

    <T> Set<T> findBySchoolId(String schoolId, Class<T> projection);

}
