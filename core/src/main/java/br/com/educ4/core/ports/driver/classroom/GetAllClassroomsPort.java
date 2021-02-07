package br.com.educ4.core.ports.driver.classroom;

import java.util.List;

public interface GetAllClassroomsPort {

    <T> List<T> execute(Class<T> projection);

}
