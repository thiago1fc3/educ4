package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.domain.Collaborator;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateClassroomUS implements CreateClassroomPort {

    private final ClassroomRepositoryPort repository;

    @Override
    public Classroom execute(String schoolId, String professorId, Classroom classroom) {

        classroom.setSchoolId(schoolId);

        var collaborator = Collaborator.create()
                .setAdmin(true)
                .setProfessorId(professorId);

        classroom.addCollaborator(collaborator);

        return repository.save(classroom);

    }
}
