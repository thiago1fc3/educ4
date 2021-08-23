package br.com.educ4.core.userstory.week;

import br.com.educ4.core.domain.TopicWeek;
import br.com.educ4.core.ports.driven.repository.weeks.TopicWeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.AddTopicToWeekPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddTopicToWeekUS implements AddTopicToWeekPort {

    private final TopicWeekRepositoryPort repository;

    @Override
    public TopicWeek execute(ObjectId weekId, TopicWeek topic) {
        topic.setWeekId(weekId);
        return repository.save(topic);
    }
}
