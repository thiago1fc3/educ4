package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class FindClassroomByIdUS implements FindClassroomByIdPort {

    private final ClassroomRepositoryPort repository;

    public Classroom execute(String id) {
        return repository.findById(id);
    }

}
