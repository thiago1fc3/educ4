package br.com.educ4.core.ports.driven.repository.school;

import br.com.educ4.core.domain.School;

public interface SaveSchoolRepositoryPort {

    public School execute(School school);

}
