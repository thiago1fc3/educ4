package br.com.educ4.repository;

import br.com.educ4.core.domain.Institution;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstitutionRepository extends MongoRepository<Institution, String> {

}
