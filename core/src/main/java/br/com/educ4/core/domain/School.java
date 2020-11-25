package br.com.educ4.core.domain;

import static br.com.educ4.core.domain.exceptions.Error.required;
import static java.util.Objects.isNull;

public final class School {

    private String id;
    private String name;

    public School id(String id) {
        if (isNull(id))
            required("Id");

        this.id = id;
        return this;
    }

    public School name(String name) {
        if (isNull(name) || name.isBlank())
            required("Name");
        this.name = name;
        return this;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

}
