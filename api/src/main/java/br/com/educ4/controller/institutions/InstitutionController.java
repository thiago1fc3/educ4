package br.com.educ4.controller.institutions;

import br.com.educ4.controller.institutions.requests.InstitutionRequest;
import br.com.educ4.controller.institutions.responses.InstitutionResponse;
import br.com.educ4.core.domain.Institution;
import br.com.educ4.core.ports.driver.institution.CreateInstitutionPort;
import br.com.educ4.core.ports.driver.institution.FindInstitutionByIdPort;
import br.com.educ4.core.ports.driver.institution.GetAllInstitutionsPort;
import br.com.educ4.core.ports.driver.institution.PatchInstitutionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("institutions")
@RequiredArgsConstructor
public class InstitutionController {

    private final CreateInstitutionPort createInstitutionPort;
    private final PatchInstitutionPort patchInstitutionPort;
    private final FindInstitutionByIdPort findInstitutionByIdPort;
    private final GetAllInstitutionsPort getAllInstitutionsPort;

    @PostMapping
    public InstitutionResponse post(@RequestBody InstitutionRequest request) {
        var institution = createInstitutionPort.execute(request.toInstitution());
        return InstitutionResponse.toResponse(institution);
    }

    @PatchMapping("{institutionId}")
    public InstitutionResponse patch(@PathVariable String institutionId, @RequestBody InstitutionRequest request) {
        var institution = patchInstitutionPort.execute(institutionId, request.toInstitution());
        return InstitutionResponse.toResponse(institution);
    }

    @GetMapping
    public List<Institution> getAll() {
        // TODO buscar todas as instituições de uma escola
        return getAllInstitutionsPort.execute(Institution.class);
    }

    @GetMapping("{institutionId}")
    public Institution getById(@PathVariable String institutionId) {
        return findInstitutionByIdPort.execute(institutionId, Institution.class);
    }
}
