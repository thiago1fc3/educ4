package br.com.educ4.core.services.school;

import br.com.educ4.core.domain.School;

import java.util.Objects;

public class SchoolService {

    public static School execute(School school) {

        if(Objects.isNull(school.getName()) || school.getName().isBlank())
            throw new RuntimeException("O atributo name é obrigatório!");

        return school;
    }

}
