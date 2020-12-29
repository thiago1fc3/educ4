package br.com.educ4.resources.institutions;

import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driver.institution.CreateInstitutionPort;
import br.com.educ4.core.ports.driver.institution.FindInstitutionByIdPort;
import br.com.educ4.core.ports.driver.institution.GetAllInstitutionsPort;
import br.com.educ4.core.ports.driver.institution.PatchInstitutionPort;
import br.com.educ4.resources.institutions.request.InstitutionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("institutions")
@RequiredArgsConstructor
public class InstitutionResource {

    private final CreateInstitutionPort createInstitutionPort;
    private final PatchInstitutionPort patchInstitutionPort;
    private final FindInstitutionByIdPort findInstitutionByIdPort;
    private final GetAllInstitutionsPort getAllInstitutionsPort;

    @PostMapping
    public Map<String, Object> post(@RequestBody InstitutionRequest request) {
        var response = createInstitutionPort.execute(request.toInstitution());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{institutionId}")
    public Map<String, Object> patch(@PathVariable String institutionId, @RequestBody InstitutionRequest request) {
        var response = patchInstitutionPort.execute(institutionId, request.toInstitution());
        return Map.of("id", response.getId());
    }

    @GetMapping
    public List<Institution> getAll() {
        return getAllInstitutionsPort.execute();
    }

    @GetMapping("{institutionId}")
    public Institution getById(@PathVariable String institutionId) {
        return findInstitutionByIdPort.execute(institutionId);
    }
}
