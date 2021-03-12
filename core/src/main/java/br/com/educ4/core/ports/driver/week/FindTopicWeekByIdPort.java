package br.com.educ4.core.ports.driver.week;

public interface FindTopicWeekByIdPort {

    <T> T execute(String id, Class<T> projection);
}
