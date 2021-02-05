package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Classroom {

    private String id;
    private String name;
    private String course;
    private LocalDate beginDate;
    private LocalDate endDate;

    private String schoolId;

    private List<Collaborator> collaborators;

    public void addCollaborator(Collaborator collaborator) {
        if (Objects.isNull(collaborators))
            collaborators = new ArrayList<>();

        collaborators.add(collaborator);
    }

}

