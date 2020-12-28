package br.com.educ4.resources.classrooms.request;

import br.com.educ4.core.domain.Classroom;
import lombok.Setter;

import java.time.LocalDate;

@Setter
public class ClassroomRequest {

    private String name;
    private String course;
    private LocalDate beginDate;
    private LocalDate endDate;

    public Classroom toClassroom() {
        return Classroom.builder()
                .name(name)
                .course(course)
                .beginDate(beginDate)
                .endDate(endDate)
                .build();
    }

}
