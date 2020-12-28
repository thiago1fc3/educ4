package br.com.educ4.core.ports.driver.classroom;

import br.com.educ4.core.domain.Classroom;

public interface FindClassroomByIdPort {

    Classroom execute(String id);

}
