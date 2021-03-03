package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class FindClassroomByIdUS implements FindClassroomByIdPort {

    private final ClassroomRepositoryPort repository;

    @Override
    public <T> T execute(String id, Class<T> projection) {
        return repository.findById(id, projection);
    }
}
