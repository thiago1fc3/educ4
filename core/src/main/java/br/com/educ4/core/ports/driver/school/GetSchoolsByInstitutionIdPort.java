package br.com.educ4.core.ports.driver.school;

import java.util.List;

public interface GetSchoolsByInstitutionIdPort {

    <T> List<T> execute(String institutionId, Class<T> projection);

}
