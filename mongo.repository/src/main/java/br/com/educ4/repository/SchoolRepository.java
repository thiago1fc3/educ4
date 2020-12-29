package br.com.educ4.repository;

import br.com.educ4.core.domain.School;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SchoolRepository extends MongoRepository<School, String> {

    List<School> findByInstitutionId(String institutionId);

}
