package br.com.educ4.resources.professors;

import br.com.educ4.core.ports.driver.professor.CreateProfessorPort;
import br.com.educ4.resources.professors.request.ProfessorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("professors")
@RequiredArgsConstructor
public class ProfessorResource {

    private final CreateProfessorPort createProfessorPort;

    @PostMapping
    public Map<String, Object> post(@RequestBody @Validated ProfessorRequest request) {
        var response = createProfessorPort.execute(request.toProfessor());
        return Map.of("id", response.getId());
    }

}
