package br.com.educ4.core.ports.driver.week;

import org.bson.types.ObjectId;

import java.time.LocalDate;

public interface CreateWeeksByRangeDatePort {
    void execute(ObjectId classroomId, LocalDate begin, LocalDate end);
}
