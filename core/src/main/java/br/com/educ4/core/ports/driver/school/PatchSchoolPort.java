package br.com.educ4.core.ports.driver.school;

import br.com.educ4.core.domain.School;

public interface PatchSchoolPort {

    School execute(String schoolId, School school);

}
