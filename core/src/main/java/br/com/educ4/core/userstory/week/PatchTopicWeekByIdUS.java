package br.com.educ4.core.userstory.week;

import br.com.educ4.core.domain.TopicWeek;
import br.com.educ4.core.ports.driven.repository.weeks.TopicWeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.FindTopicWeekByIdPort;
import br.com.educ4.core.ports.driver.week.PatchTopicWeekByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static br.com.educ4.core.utils.MapperConfig.getMapper;

@Named
@RequiredArgsConstructor
public class PatchTopicWeekByIdUS implements PatchTopicWeekByIdPort {

    private final TopicWeekRepositoryPort repository;
    private final FindTopicWeekByIdUS findTopicWeekByIdUS;

    @Override
    public TopicWeek execute(String topicId, TopicWeek topicWeek) {

        var dbTopicWeek = findTopicWeekByIdUS.execute(topicId, TopicWeek.class);

        getMapper().map(topicWeek, dbTopicWeek);

        return repository.save(dbTopicWeek);

    }
}
