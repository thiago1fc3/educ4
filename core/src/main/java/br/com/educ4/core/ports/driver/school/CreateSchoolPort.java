package br.com.educ4.core.ports.driver.school;

import br.com.educ4.core.domain.School;

public interface CreateSchoolPort {

    public School execute(School school);

}