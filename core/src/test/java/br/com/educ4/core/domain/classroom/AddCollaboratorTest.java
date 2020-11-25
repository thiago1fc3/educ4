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

@DisplayName("Classroom add collaborator test")
class AddCollaboratorTest {

    private Classroom classroom;

    @BeforeEach
    public void prepare() {
        classroom = new Classroom();
    }

    @Test
    @DisplayName("Should return error when collaborator is null")
    public void shouldReturnErrorWhenCollaboratorIsNull() {
        try {
            classroom.add(null);
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    @DisplayName("Should correct add when collaborator is valid")
    public void shouldCorrectAddWhenCollaboratorIsValid() {
        var professorId = UUID.randomUUID().toString();
        var collaborator = new Collaborator(professorId);
        var collaboratorsSize = classroom.collaborators().size();

        classroom.add(collaborator);

        assertEquals(collaboratorsSize + 1, classroom.collaborators().size());
        assertTrue(classroom.isCollaborator(professorId));
    }

}