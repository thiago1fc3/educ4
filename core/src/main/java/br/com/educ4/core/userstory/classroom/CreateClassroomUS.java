package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateClassroomUS implements CreateClassroomPort {
    private final ClassroomRepositoryPort repository;

    @Override
    public Classroom execute(String schoolId, Classroom classroom) {
        classroom.setSchoolId(schoolId);
        return repository.save(classroom);
    }
}
