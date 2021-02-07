package br.com.educ4.core.ports.driver.institution;

import java.util.List;

public interface GetAllInstitutionsPort {

    <T> List<T> execute(Class<T> projection);

}
