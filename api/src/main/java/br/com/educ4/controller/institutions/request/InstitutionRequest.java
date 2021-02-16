package br.com.educ4.controller.institutions.request;

import br.com.educ4.core.domain.Institution;
import lombok.Setter;

@Setter
public class InstitutionRequest {

    private String name;

    public Institution toInstitution() {
        return Institution.builder()
                .name(name)
                .build();
    }

}
