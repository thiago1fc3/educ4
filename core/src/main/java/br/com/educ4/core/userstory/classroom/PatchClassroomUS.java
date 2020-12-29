package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.PatchClassroomPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class PatchClassroomUS implements PatchClassroomPort {

    private final FindClassroomByIdUS findClassroomByIdUS;
    private final ClassroomRepositoryPort repository;

    @Override
    public Classroom execute(String classroomId, Classroom classroom) {
        var dbClassroom = findClassroomByIdUS.execute(classroomId);

        dbClassroom.setName(classroom.getName());
        dbClassroom.setBeginDate(classroom.getBeginDate());
        dbClassroom.setEndDate(classroom.getEndDate());
        dbClassroom.setCourse(classroom.getCourse());

        return repository.save(dbClassroom);
    }
}
