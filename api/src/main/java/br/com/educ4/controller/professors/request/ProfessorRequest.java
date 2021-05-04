package br.com.educ4.controller.professors.request;

import br.com.educ4.core.domain.Professor;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;

@Setter
public class ProfessorRequest {

    @NotEmpty
    private String userId;
    private String registration;

    public Professor toProfessor() {
        return Professor.builder()
                .userId(new ObjectId(userId))
                .registration(registration)
                .build();
    }

}
