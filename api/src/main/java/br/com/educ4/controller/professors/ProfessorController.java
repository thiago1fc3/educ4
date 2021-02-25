package br.com.educ4.controller.professors;

import br.com.educ4.controller.professors.request.ProfessorRequest;
import br.com.educ4.controller.professors.response.ShowProfessorResponse;
import br.com.educ4.core.ports.driver.professor.*;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final FindProfessorByIdPort findProfessorByIdPort;
    private final FindProfessorsBySchoolIdPort findProfessorsBySchoolIdPort;
    private final CreateProfessorPort createProfessorPort;
    private final UpdateProfessorPort updateProfessorPort;
    private final FindProfessorBySchoolIdAndUserIdPort findProfessorBySchoolIdAndUserIdPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable String schoolId, @RequestBody @Validated ProfessorRequest request) {
        var response = createProfessorPort.execute(schoolId, request.toProfessor());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{userId}")
    public void patch(@PathVariable String schoolId, @PathVariable ObjectId userId, @RequestBody ProfessorRequest request) {
        updateProfessorPort.execute(schoolId, userId, request.toProfessor());
    }

    @GetMapping
    public List<ShowProfessorResponse> get(@PathVariable ObjectId schoolId) {
        return findProfessorsBySchoolIdPort.execute(schoolId, ShowProfessorResponse.class);
    }

    @GetMapping("{userId}")
    public ShowProfessorResponse getById(@PathVariable String schoolId, @PathVariable ObjectId userId) {
        return findProfessorBySchoolIdAndUserIdPort.execute(schoolId, userId, ShowProfessorResponse.class);
    }

}
