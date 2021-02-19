package br.com.educ4.controller.professors;

import br.com.educ4.controller.professors.request.ProfessorRequest;
import br.com.educ4.controller.professors.response.ShowNameResponse;
import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.ports.driver.professor.CreateProfessorPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorByIdPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorsBySchoolIdPort;
import br.com.educ4.core.ports.driver.professor.UpdateProfessorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("schools/{schoolId}/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final FindProfessorByIdPort findProfessorByIdPort;
    private final FindProfessorsBySchoolIdPort findProfessorsBySchoolIdPort;
    private final CreateProfessorPort createProfessorPort;
    private final UpdateProfessorPort updateProfessorPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable String schoolId, @RequestBody @Validated ProfessorRequest request) {
        var response = createProfessorPort.execute(schoolId, request.toProfessor());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{userId}")
    public void patch(@PathVariable String schoolId, @PathVariable String userId, @RequestBody ProfessorRequest request) {
        updateProfessorPort.execute(schoolId, userId, request.toProfessor());
    }

    @GetMapping
    public Set<ShowNameResponse> get(@PathVariable String schoolId) {
        return findProfessorsBySchoolIdPort.execute(schoolId, ShowNameResponse.class);
    }

    @GetMapping("{professorId}")
    public Professor getById(@PathVariable String userId, @PathVariable String professorId) {
        return findProfessorByIdPort.execute(professorId, Professor.class);
    }

}
