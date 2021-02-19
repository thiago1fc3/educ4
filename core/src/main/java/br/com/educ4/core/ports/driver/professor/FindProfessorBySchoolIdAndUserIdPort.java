package br.com.educ4.core.ports.driver.professor;

public interface FindProfessorBySchoolIdAndUserIdPort {
    <T> T execute(String schoolId, String userId, Class<T> projection);
}
