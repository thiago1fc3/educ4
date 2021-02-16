package br.com.educ4.core.ports.driver.classroom;

public interface FindClassroomByIdPort {

    <T> T execute(String id, Class<T> projection);

}
