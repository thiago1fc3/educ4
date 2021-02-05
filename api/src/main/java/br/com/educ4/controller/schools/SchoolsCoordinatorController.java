package br.com.educ4.controller.schools;

import br.com.educ4.core.ports.driver.school.AddCoordinatorsToSchoolPort;
import br.com.educ4.core.ports.driver.school.RemoveCoordinatorsToSchoolPort;
import br.com.educ4.controller.schools.request.IdsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/coordinators")
@RequiredArgsConstructor
public class SchoolsCoordinatorController {
    private final AddCoordinatorsToSchoolPort addCoordinatorsToSchoolPort;
    private final RemoveCoordinatorsToSchoolPort removeCoordinatorsToSchoolPort;

    @PatchMapping
    public Map<String, Object> patch(@PathVariable String schoolId, @RequestBody IdsRequest request) {
        var response = addCoordinatorsToSchoolPort.execute(schoolId, request.getIds());
        return Map.of("id", response.getId());
    }

    @DeleteMapping
    public Map<String, Object> delete(@PathVariable String schoolId, @RequestBody IdsRequest request) {
        var response = removeCoordinatorsToSchoolPort.execute(schoolId, request.getIds());
        return Map.of("id", response.getId());
    }

}
