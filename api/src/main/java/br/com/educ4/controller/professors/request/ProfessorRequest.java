package br.com.educ4.controller.professors.request;

import br.com.educ4.core.domain.Professor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
public class ProfessorRequest {

    @NotEmpty
    private String userId;
    private String registration;

    public Professor toProfessor() {
        return Professor.builder()
                .userId(userId)
                .registration(registration)
                .build();
    }

}
