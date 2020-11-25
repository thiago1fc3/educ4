package br.com.educ4.core.domain.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.domain.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.educ4.core.domain.exceptions.Status.REQUIRED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Classroom set name test")
class SetNameTest {

    private Classroom classroom;

    @BeforeEach
    public void prepare() {
        classroom = new Classroom();
    }

    @Test
    public void shouldReturnErrorWhenNameIsNull() {
        try {
            classroom.name(null);
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    public void shouldReturnErrorWhenNameIsBlank() {
        try {
            classroom.name("");
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    @DisplayName("Should correct name when name is valid")
    public void shouldCorrectNameWhenNameIsValid() {
        var name = "Fundamentals of programming in C++";
        classroom.name(name);
        assertEquals(classroom.name(), name);
    }

}