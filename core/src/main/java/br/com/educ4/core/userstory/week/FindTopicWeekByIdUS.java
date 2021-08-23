package br.com.educ4.core.userstory.week;

import br.com.educ4.core.ports.driven.repository.weeks.TopicWeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.FindTopicWeekByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FindTopicWeekByIdUS implements FindTopicWeekByIdPort {

    private final TopicWeekRepositoryPort repository;


    @Override
    public <T> T execute(String id, Class<T> projection) {
        return repository.findById(id, projection).orElseThrow(() -> new NoSuchElementException("Topic not found!"));
    }
}
