package br.com.educ4.core.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static br.com.educ4.core.domain.exceptions.Error.required;
import static java.util.Objects.isNull;

public final class Classroom {

    private String id;
    private String name;
    private String course;
    private LocalDate begin;
    private LocalDate end;
    private Set<Collaborator> collaborators;

    public Classroom() {
        collaborators = new HashSet<>();
    }

    public Classroom id(final String id) {
        if (isNull(id))
            required("Id");
        this.id = id;

        return this;
    }

    public Classroom name(final String name) {
        if (isNull(name))
            required("Name");
        if (name.isBlank())
            required("Name");

        this.name = name;
        return this;
    }

    public Classroom course(final String course) {
        if (isNull(course))
            required("Course");
        if (course.isBlank())
            required("Course");

        this.course = course;
        return this;
    }

    public Classroom add(Collaborator collaborator) {
        if (isNull(collaborator))
            required("Collaborator");

        collaborators.add(collaborator);
        return this;
    }

    public boolean isCollaborator(String professorId) {
        if (isNull(professorId))
            required("Professor");

        if (isNull(professorId))
            required("Professor id");

        return collaborators
                .stream()
                .map(c -> c.professorId())
                .anyMatch(professorId::equals);
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Set<Collaborator> collaborators() {
        return Set.copyOf(collaborators);
    }

    public String course() {
        return course;
    }
}
