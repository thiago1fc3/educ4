package br.com.educ4.core.ports.driver.school;

import java.util.List;

public interface GetAllSchoolsPort {

    <T> List<T> execute(Class<T> projection);

}
