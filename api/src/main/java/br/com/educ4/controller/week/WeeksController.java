package br.com.educ4.controller.week;

import br.com.educ4.core.domain.Week;
import br.com.educ4.core.ports.driver.week.GetWeeksByClassroomIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("classrooms/{classroomId}/weeks")
@RequiredArgsConstructor
public class WeeksController {

    private final GetWeeksByClassroomIdPort getWeeksByClassroomIdPort;

    @GetMapping
    public List<Week> getAll(@PathVariable ObjectId classroomId) {
        return getWeeksByClassroomIdPort.execute(classroomId, Week.class);
    }
}
