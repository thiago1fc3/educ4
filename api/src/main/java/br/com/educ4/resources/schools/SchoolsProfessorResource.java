package br.com.educ4.resources.schools;

import br.com.educ4.core.ports.driver.school.AddCoordinatorsToSchoolPort;
import br.com.educ4.core.ports.driver.school.AddProfessorsToSchoolPort;
import br.com.educ4.core.ports.driver.school.RemoveCoordinatorsToSchoolPort;
import br.com.educ4.resources.schools.request.IdsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/professors")
@RequiredArgsConstructor
public class SchoolsProfessorResource {
    private final AddProfessorsToSchoolPort addProfessorsToSchoolPort;

    @PatchMapping
    public Map<String, Object> patch(@PathVariable String schoolId, @RequestBody IdsRequest request) {
        var response = addProfessorsToSchoolPort.execute(schoolId, request.getIds());
        return Map.of("id", response.getId());
    }

}
