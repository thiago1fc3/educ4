package br.com.educ4.controller.professors;

import br.com.educ4.controller.professors.request.ProfessorRequest;
import br.com.educ4.controller.professors.response.ShowNameProfessorResponse;
import br.com.educ4.controller.schools.request.IdsRequest;
import br.com.educ4.core.domain.Professor;
import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.professor.CreateProfessorPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorByIdPort;
import br.com.educ4.core.ports.driver.professor.FindProfessorsBySchoolIdPort;
import br.com.educ4.core.ports.driver.professor.GetProfessorsByUserIdPort;
import br.com.educ4.core.ports.driver.school.AddProfessorsToSchoolPort;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/professors")
@RequiredArgsConstructor
public class ProfessorController {

    private final CreateProfessorPort createProfessorPort;
    private final FindProfessorByIdPort findProfessorByIdPort;
    private final FindProfessorsBySchoolIdPort findProfessorsBySchoolIdPort;
    private final AddProfessorsToSchoolPort addProfessorsToSchoolPort;

    @PostMapping
    public Map<String, Object> post(@RequestBody @Validated ProfessorRequest request) {
        var response = createProfessorPort.execute(request.toProfessor());
        return Map.of("id", response.getId());
    }

    @PatchMapping
    public Map<String, Object> patch(@PathVariable String schoolId, @RequestBody IdsRequest request) {
        var response = addProfessorsToSchoolPort.execute(schoolId, request.getIds());
        return Map.of("id", response.getId());
    }

    @GetMapping
    public List<ShowNameProfessorResponse> get(@PathVariable String schoolId) {
        return findProfessorsBySchoolIdPort.execute(schoolId, ShowNameProfessorResponse.class);
    }

    @GetMapping("{professorId}")
    public Professor getById(@PathVariable String userId, @PathVariable String professorId) {
        return findProfessorByIdPort.execute(professorId, Professor.class);
    }

}
