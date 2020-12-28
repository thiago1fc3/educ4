package br.com.educ4.repository;

import br.com.educ4.core.domain.Classroom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassroomRepository extends MongoRepository<Classroom, String> {
}
