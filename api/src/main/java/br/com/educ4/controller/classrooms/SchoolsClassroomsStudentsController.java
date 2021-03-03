package br.com.educ4.controller.classrooms;

import br.com.educ4.core.ports.driver.classroom.AddStudentToClassroomPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("classrooms/{classroomId}/students")
@RequiredArgsConstructor
public class SchoolsClassroomsStudentsController {

    private final AddStudentToClassroomPort addStudentToClassroomPort;

    @PatchMapping("{studentId}")
    public void patch(@PathVariable String classroomId, @PathVariable ObjectId studentId) {
        addStudentToClassroomPort.execute(classroomId, studentId);
    }

}
