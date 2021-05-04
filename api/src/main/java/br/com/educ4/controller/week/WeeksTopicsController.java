package br.com.educ4.controller.week;

import br.com.educ4.controller.week.request.WeekTopicsRequest;
import br.com.educ4.core.domain.TopicWeek;
import br.com.educ4.core.domain.Week;
import br.com.educ4.core.ports.driver.week.AddTopicToWeekPort;
import br.com.educ4.core.ports.driver.week.DeleteTopicWeekByIdPort;
import br.com.educ4.core.ports.driver.week.GetTopicsByWeekIdPort;
import br.com.educ4.core.ports.driver.week.PatchTopicWeekByIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("weeks/{weekId}/topics")
@RequiredArgsConstructor
public class WeeksTopicsController {

    private final AddTopicToWeekPort addTopicToWeekPort;
    private final DeleteTopicWeekByIdPort deleteTopicWeekByIdPort;
    private final PatchTopicWeekByIdPort patchTopicWeekByIdPort;
    private final GetTopicsByWeekIdPort getTopicsByWeekIdPort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addTopicToWeekPort(@PathVariable ObjectId weekId, @RequestBody WeekTopicsRequest request) {
        var response = addTopicToWeekPort.execute(weekId, request.toWeekTopic());
        return Map.of("id", response.getId());
    }

    @DeleteMapping("{topicId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopicWeekById(@PathVariable ObjectId weekId, @PathVariable String topicId) {
        deleteTopicWeekByIdPort.execute(topicId);
    }

    @PatchMapping("{topicId}")
    @ResponseStatus(HttpStatus.OK)
    public void patchTopicWeekById(@PathVariable ObjectId weekId, @PathVariable String topicId, @RequestBody WeekTopicsRequest request) {
        patchTopicWeekByIdPort.execute(topicId, request.toWeekTopic());
    }

    @GetMapping
    public List<TopicWeek> getAll(@PathVariable ObjectId weekId) {
        return getTopicsByWeekIdPort.execute(weekId, TopicWeek.class);
    }
}
