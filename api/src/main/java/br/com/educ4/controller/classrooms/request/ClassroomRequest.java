package br.com.educ4.controller.classrooms.request;

import br.com.educ4.core.domain.Classroom;
import lombok.Setter;

import java.time.LocalDate;

@Setter
public class ClassroomRequest {

    private String name;
    private String description;
    private String course;
    private LocalDate beginDate;
    private LocalDate endDate;

    public Classroom toClassroom() {
        return Classroom.builder()
                .name(name)
                .description(description)
                .course(course)
                .beginDate(beginDate)
                .endDate(endDate)
                .build();
    }

}
