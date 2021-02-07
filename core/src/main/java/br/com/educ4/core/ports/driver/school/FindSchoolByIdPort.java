package br.com.educ4.core.ports.driver.school;

public interface FindSchoolByIdPort {

    <T> T execute(String id, Class<T> projection);

}
