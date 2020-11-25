package br.com.educ4.core.domain.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.domain.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.educ4.core.domain.exceptions.Status.REQUIRED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Classroom set id test")
class SetIdTest {

    private Classroom classroom;

    @BeforeEach
    public void prepare() {
        classroom = new Classroom();
    }

    @Test
    @DisplayName("Should return error when id is null")
    public void shouldReturnErrorWhenIdIsNull() {
        try {
            classroom.id(null);
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    @DisplayName("Should correct id when id is valid")
    public void shouldCorrectIdWhenIdIsValid() {
        var id = UUID.randomUUID().toString();
        classroom.id(id);
        assertEquals(classroom.id(), id);
    }

}