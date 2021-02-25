package br.com.educ4.core.ports.driver.professor;

public interface FindProfessorByIdPort {

    <T> T execute(String id, Class<T> projection);

}
