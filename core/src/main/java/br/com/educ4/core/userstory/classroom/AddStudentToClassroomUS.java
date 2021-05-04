package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.AddStudentToClassroomPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class AddStudentToClassroomUS implements AddStudentToClassroomPort {

    private final FindClassroomByIdPort findClassroomByIdPort;
    private final ClassroomRepositoryPort repository;

    @Override
    public void execute(String classroomId, ObjectId studentId) {
        var dbClassroom = findClassroomByIdPort.execute(classroomId, Classroom.class);

        dbClassroom.addStudent(studentId);

        repository.save(dbClassroom);
    }

}
