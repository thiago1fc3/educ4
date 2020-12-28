package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.FindByIdSchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.FindByIdSchoolPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class FindByIdSchoolUS implements FindByIdSchoolPort {

    private final FindByIdSchoolRepositoryPort repositoryPort;

    public School execute(String id) {
        return repositoryPort.execute(id);
    }
}
