package br.com.educ4.core.ports.driver.professor;

public interface ExitsProfessorBySchoolIdAndUserIdPort {
    boolean execute(String schoolId, String userId);
}
