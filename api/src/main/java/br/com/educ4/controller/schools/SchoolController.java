package br.com.educ4.controller.schools;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.core.ports.driver.school.FindSchoolByIdPort;
import br.com.educ4.core.ports.driver.school.GetSchoolsByInstitutionIdPort;
import br.com.educ4.core.ports.driver.school.PatchSchoolPort;
import br.com.educ4.controller.schools.request.SchoolRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("institutions/{institutionId}/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final CreateSchoolPort createSchoolPort;
    private final PatchSchoolPort patchSchoolPort;
    private final FindSchoolByIdPort findSchoolByIdPort;
    private final GetSchoolsByInstitutionIdPort getSchoolsByInstitutionIdPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable String institutionId, @RequestBody SchoolRequest request) {
        var response = createSchoolPort.execute(institutionId, request.toSchool());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{schoolId}")
    public Map<String, Object> patch(@PathVariable String institutionId, @PathVariable String schoolId, @RequestBody SchoolRequest request) {
        var response = patchSchoolPort.execute(schoolId, request.toSchool());
        return Map.of("id", response.getId());
    }

    @GetMapping
    public List<School> getAll(@PathVariable String institutionId) {
        return getSchoolsByInstitutionIdPort.execute(institutionId);
    }

    @GetMapping("{schoolId}")
    public School getById(@PathVariable String institutionId, @PathVariable String schoolId) {
        // TODO Verificar se a escola pertence a instituição
        return findSchoolByIdPort.execute(schoolId);
    }
}
