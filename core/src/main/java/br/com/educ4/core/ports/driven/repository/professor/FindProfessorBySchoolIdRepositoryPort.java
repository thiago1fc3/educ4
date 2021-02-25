package br.com.educ4.core.ports.driven.repository.professor;

import org.bson.types.ObjectId;

import java.util.List;

public interface FindProfessorBySchoolIdRepositoryPort {

    <T> List<T> findBySchoolId(ObjectId schoolId, Class<T> projection);

}
