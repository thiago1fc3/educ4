package br.com.educ4.resources.school.request;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.domain.User;
import lombok.Setter;

@Setter

public class CreateSchoolRequest {

    private String name;

    public School toSchool(){
        return  School.builder()
                .name(name)
                .build();
    }

}
