package br.com.educ4.repository;

import br.com.educ4.core.domain.Week;
import br.com.educ4.core.ports.driven.repository.weeks.WeekRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeekRepository extends MongoRepository<Week, String>, WeekRepositoryPort {

}
