package br.com.educ4.core.ports.driver.professor;

import java.util.List;

public interface GetProfessorsByUserIdPort {

    <T> List<T> execute(String userId, Class<T> projection);

}
