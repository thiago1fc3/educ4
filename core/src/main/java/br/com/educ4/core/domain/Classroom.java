package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Classroom {

    private String id;
    private String name;
    private String course;
    private LocalDate beginDate;
    private LocalDate endDate;

    private String schoolId;

}

