package br.com.educ4.core.ports.driver.week;

import br.com.educ4.core.domain.TopicWeek;

public interface PatchTopicWeekByIdPort {

    TopicWeek execute(String topicId, TopicWeek topicWeek);
}
