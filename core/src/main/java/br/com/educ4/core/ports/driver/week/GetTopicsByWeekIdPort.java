package br.com.educ4.core.ports.driver.week;

import org.bson.types.ObjectId;

import java.util.List;

public interface GetTopicsByWeekIdPort {

    <T> List<T> execute(ObjectId weekId, Class<T> projection);

}
