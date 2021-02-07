package br.com.educ4.core.userstory.school;

import br.com.educ4.core.ports.driven.repository.school.SchoolRepositoryPort;
import br.com.educ4.core.ports.driver.school.FindSchoolByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.NoSuchElementException;

@Named
@RequiredArgsConstructor
public class FindSchoolByIdUS implements FindSchoolByIdPort {

    private final SchoolRepositoryPort repository;

    public <T> T execute(String id, Class<T> projection) {
        return repository.findById(id, projection).orElseThrow(() -> new NoSuchElementException("School not found!"));
    }
}
