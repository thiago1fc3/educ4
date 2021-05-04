package br.com.educ4.core.ports.driver.week;

import br.com.educ4.core.domain.TopicWeek;
import org.bson.types.ObjectId;

public interface AddTopicToWeekPort {

    TopicWeek execute(ObjectId weekId, TopicWeek topic);
}
