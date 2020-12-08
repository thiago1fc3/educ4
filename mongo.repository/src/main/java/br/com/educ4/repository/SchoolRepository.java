package br.com.educ4.repository;

import br.com.educ4.entities.SchoolDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository extends MongoRepository<SchoolDocument, String> {
}
