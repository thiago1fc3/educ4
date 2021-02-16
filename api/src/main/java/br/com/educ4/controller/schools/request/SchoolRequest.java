package br.com.educ4.controller.schools.request;

import br.com.educ4.core.domain.School;
import lombok.Setter;

@Setter
public class SchoolRequest {

    private String name;

    public School toSchool(){
        return  School.builder()
                .name(name)
                .build();
    }

}
