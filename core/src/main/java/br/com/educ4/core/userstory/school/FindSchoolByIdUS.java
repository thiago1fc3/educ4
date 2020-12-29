package br.com.educ4.core.userstory.school;

import br.com.educ4.core.domain.School;
import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.FindSchoolByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class FindSchoolByIdUS implements FindSchoolByIdPort {

    private final SchoolRepositoryPort repository;

    public School execute(String id) {
        return repository.findById(id);
    }
}
