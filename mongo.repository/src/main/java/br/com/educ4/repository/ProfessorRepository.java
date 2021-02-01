package br.com.educ4.repository;

import br.com.educ4.core.domain.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String> {


}
