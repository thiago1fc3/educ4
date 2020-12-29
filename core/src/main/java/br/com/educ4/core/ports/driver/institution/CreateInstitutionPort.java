package br.com.educ4.core.ports.driver.institution;

import br.com.educ4.core.domain.Institution;

public interface CreateInstitutionPort {

    Institution execute(Institution institution);

}
