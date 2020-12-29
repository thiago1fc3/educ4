package br.com.educ4.resources.schools;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driver.school.CreateSchoolPort;
import br.com.educ4.core.ports.driver.school.FindSchoolByIdPort;
import br.com.educ4.core.ports.driver.school.GetAllSchoolsPort;
import br.com.educ4.core.ports.driver.school.PatchSchoolPort;
import br.com.educ4.resources.schools.request.SchoolRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schools")
@RequiredArgsConstructor
public class SchoolResource {

    private final CreateSchoolPort createSchoolPort;
    private final PatchSchoolPort patchSchoolPort;
    private final FindSchoolByIdPort findSchoolByIdPort;
    private final GetAllSchoolsPort getAllSchoolsPort;

    @PostMapping
    public Map<String, Object> post(@RequestBody SchoolRequest request) {
        var response = createSchoolPort.execute(request.toSchool());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{schoolId}")
    public Map<String, Object> patch(@PathVariable String schoolId, @RequestBody SchoolRequest request) {
        var response = patchSchoolPort.execute(schoolId, request.toSchool());
        return Map.of("id", response.getId());
    }

    @GetMapping
    public List<School> getAll() {
        return getAllSchoolsPort.execute();
    }

    @GetMapping("{schoolId}")
    public School getById(@PathVariable String schoolId) {
        return findSchoolByIdPort.execute(schoolId);
    }
}
