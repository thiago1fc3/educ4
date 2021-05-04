package br.com.educ4.core.userstory.week;

import br.com.educ4.core.ports.driven.repository.weeks.TopicWeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.DeleteTopicWeekByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class DeleteTopicWeekByIdUS implements DeleteTopicWeekByIdPort {

    private final TopicWeekRepositoryPort repository;

    @Override
    public void execute(String topicId) {
        repository.deleteById(topicId);
    }
}
