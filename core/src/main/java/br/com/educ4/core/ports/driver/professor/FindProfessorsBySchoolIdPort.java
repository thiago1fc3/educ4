package br.com.educ4.core.ports.driver.professor;

import java.util.List;

public interface FindProfessorsBySchoolIdPort {
    <T> List<T> execute(String schoolId, Class<T> projection);
}
