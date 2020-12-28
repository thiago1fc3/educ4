package br.com.educ4.core.ports.driver.classroom;

import br.com.educ4.core.domain.Classroom;

import java.util.List;

public interface GetAllClassroomsPort {

    List<Classroom> execute();

}
