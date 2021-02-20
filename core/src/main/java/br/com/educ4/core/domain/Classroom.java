package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
@Document
public class Classroom {

    private String id;
    private String name;
    private String course;
    private LocalDate beginDate;
    private LocalDate endDate;

    @Indexed
    private ObjectId schoolId;

    private Set<Collaborator> collaborators;
    private Set<ClassroomFolder> folders;

    public void addCollaborator(Collaborator collaborator) {
        if (Objects.isNull(collaborators))
            collaborators = new HashSet<>();

        collaborators.add(collaborator);
    }

}

