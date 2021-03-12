package br.com.educ4.controller.week.request;

import br.com.educ4.core.domain.TopicWeek;
import lombok.Setter;

@Setter
public class WeekTopicsRequest {

    private String title;

    public TopicWeek toWeekTopic() {
        return TopicWeek.builder()
                .title(title)
                .build();
    }
}
