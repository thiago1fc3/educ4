package br.com.educ4.core.ports.driver.professor;

import java.util.List;

public interface GetAllProfessorPort {

    <T> List<T> execute(Class<T> projection);

}
