package br.com.educ4.core.ports.driven.repository.weeks;

import br.com.educ4.core.domain.TopicWeek;

import java.util.List;
import java.util.Optional;

public interface TopicWeekRepositoryPort {

    TopicWeek save(TopicWeek topicWeek);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);

    void deleteById(String topicId);
}
