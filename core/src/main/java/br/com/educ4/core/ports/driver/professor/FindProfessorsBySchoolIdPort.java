package br.com.educ4.core.ports.driver.professor;

import java.util.Set;

public interface FindProfessorsBySchoolIdPort {
    <T> Set<T> execute(String schoolId, Class<T> projection);
}
