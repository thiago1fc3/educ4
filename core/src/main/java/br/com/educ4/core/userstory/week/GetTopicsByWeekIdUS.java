package br.com.educ4.core.userstory.week;

import br.com.educ4.core.ports.driven.repository.weeks.TopicWeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.GetTopicsByWeekIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTopicsByWeekIdUS implements GetTopicsByWeekIdPort {

    private final TopicWeekRepositoryPort repository;

    @Override
    public <T> List<T> execute(ObjectId weekId, Class<T> projection) {
        return repository.findByWeekId(weekId, projection);
    }
}
