package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.ListAllSchoolsRepositoryPort;
import br.com.educ4.core.ports.driver.school.ListAllSchoolsPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class ListAllSchoolsUS implements ListAllSchoolsPort {

    private final ListAllSchoolsRepositoryPort repositoryPort;

    public List<School> execute() {
        return repositoryPort.execute();
    }

}
