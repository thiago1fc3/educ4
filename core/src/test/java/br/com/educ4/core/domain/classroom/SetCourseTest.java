package br.com.educ4.core.domain.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.domain.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.educ4.core.domain.exceptions.Status.REQUIRED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Classroom set course test")
class SetCourseTest {

    private Classroom classroom;

    @BeforeEach
    public void prepare() {
        classroom = new Classroom();
    }

    @Test
    public void shouldReturnErrorWhenCourseIsNull() {
        try {
            classroom.course(null);
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    public void shouldReturnErrorWhenCourseIsBlank() {
        try {
            classroom.course("");
            fail("Should return error");
        } catch (DomainException ex) {
            assertEquals(ex.status(), REQUIRED);
        }
    }

    @Test
    public void shouldCorrectNameWhenNameIsValid() {
        var course = "Computer science";
        classroom.course(course);
        assertEquals(classroom.course(), course);
    }

}