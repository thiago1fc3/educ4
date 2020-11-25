package br.com.educ4.core.domain;

import java.time.LocalDateTime;

public final class Collaborator {

    private final String professorId;
    private boolean isAdmin;
    private final LocalDateTime date;

    public Collaborator(final String professorId) {
        this.professorId = professorId;
        this.date = LocalDateTime.now();
    }

    public Collaborator isAdmin(boolean isAdministrator) {
        this.isAdmin = isAdministrator;
        return this;
    }

    public String professor() {
        return professorId;
    }

    public String professorId() {
        return professorId;
    }
}
