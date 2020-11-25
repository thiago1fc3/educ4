package br.com.educ4.core.domain;

import java.util.HashSet;
import java.util.Set;

import static br.com.educ4.core.domain.exceptions.Error.required;
import static java.util.Objects.isNull;

public final class Professor {

    private String id;
    private String name;
    private Set<School> schools;

    public Professor() {
        schools = new HashSet<>();
    }

    public Professor id(String id) {
        if (isNull(id))
            required("Id");

        this.id = id;
        return this;
    }

    public Professor name(String name) {
        if (isNull(name) || name.isBlank())
            required("Name");

        this.name = name;
        return this;
    }

    public Professor add(School school) {
        if (isNull(school))
            required("School");

        schools.add(school);
        return this;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Set<School> schools() {
        return Set.copyOf(schools);
    }

}
