package br.com.educ4.core.ports.driver.institution;

public interface FindInstitutionByIdPort {

    <T> T execute(String id, Class<T> projection);

}
