package br.com.educ4.repository;

import br.com.educ4.core.domain.TopicWeek;
import br.com.educ4.core.ports.driven.repository.weeks.TopicWeekRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicWeekRepository extends MongoRepository<TopicWeek, String>, TopicWeekRepositoryPort {
}
