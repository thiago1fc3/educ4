package br.com.educ4.repository.professor;

import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driven.repository.professor.ProfessorRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String>, ProfessorRepositoryPort {

}
