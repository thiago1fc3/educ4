package br.com.educ4.core.ports.driver.school;

import br.com.educ4.core.domain.School;

import java.util.Set;

public interface AddCoordinatorsToSchoolPort {

    School execute(String schoolId, Set<String> coordinatorsIds);

}
