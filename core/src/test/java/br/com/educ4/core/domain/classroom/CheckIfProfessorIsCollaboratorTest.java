package br.com.educ4.core.domain.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.domain.Collaborator;
import br.com.educ4.core.domain.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.educ4.core.domain.exceptions.Status.REQUIRED;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classroom check collaborator test")
class CheckIfProfessorIsCollaboratorTest {

    private Classroom classroom;
    private String professorId;

    @BeforeEach
    public void prepare() {
        classroom = new Classroom();
        professorId = UUID.randomUUID().toString();
        var collaborator = new Collaborator(professorId);
        classroom.add(collaborator);
    }

    @Test
    @DisplayName("Should return error when professor is null")
    public void shouldReturnErrorWhenProfessorIsNull() {
        try {
            classroom.isCollaborator(null);
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    @DisplayName("Should return error when professor id is null")
    public void shouldReturnErrorWhenProfessorIdIsNull() {
        try {
            classroom.isCollaborator(null);
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    @DisplayName("Should return false if professor is collaborator")
    public void shouldNoErrorWhenProfessorNotIsCollaborator() {
        assertFalse(classroom.isCollaborator(UUID.randomUUID().toString()));
    }

    @Test
    @DisplayName("Should return true if professor is collaborator")
    public void shouldNoErrorWhenProfessorIsCollaborator() {
        assertTrue(classroom.isCollaborator(professorId));
    }
}