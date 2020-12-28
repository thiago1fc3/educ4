package br.com.educ4.core.ports.driver.school;

import br.com.educ4.core.domain.School;

import java.util.List;

public interface ListAllSchoolsPort {

    List<School> execute();

}
