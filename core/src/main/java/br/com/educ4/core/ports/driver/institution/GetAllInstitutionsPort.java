package br.com.educ4.core.ports.driver.institution;

import br.com.educ4.core.domain.Institution;

import java.util.List;

public interface GetAllInstitutionsPort {

    List<Institution> execute();

}
