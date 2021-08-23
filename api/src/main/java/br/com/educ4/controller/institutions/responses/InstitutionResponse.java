package br.com.educ4.controller.institutions.responses;

import br.com.educ4.core.domain.Institution;
import lombok.Getter;

@Getter
public final class InstitutionResponse {

    private String id;

    public final static InstitutionResponse toResponse(Institution institution) {

        var response = new InstitutionResponse();

        response.id = institution.getId();

        return response;

    }

}
