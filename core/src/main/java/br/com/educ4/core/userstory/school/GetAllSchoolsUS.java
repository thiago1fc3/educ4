package br.com.educ4.core.userstory.school;

import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.GetAllSchoolsPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetAllSchoolsUS implements GetAllSchoolsPort {

    private final SchoolRepositoryPort repository;

    public <T> List<T> execute(Class<T> projection) {
        return repository.findBy(projection);
    }

}
