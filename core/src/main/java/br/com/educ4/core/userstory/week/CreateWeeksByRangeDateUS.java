package br.com.educ4.core.userstory.week;

import br.com.educ4.core.domain.Week;
import br.com.educ4.core.ports.driven.repository.week.WeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.CreateWeeksByRangeDatePort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;

@Named
@RequiredArgsConstructor
public class CreateWeeksByRangeDateUS implements CreateWeeksByRangeDatePort {

    private final WeekRepositoryPort repository;

    @Override
    public void execute(ObjectId classroomId, LocalDate begin, LocalDate end) {

        var weeks = new ArrayList<Week>();

        while (begin.isBefore(end)) {
            weeks.add(createWeek(classroomId, begin));
            begin = begin.plusWeeks(1);
        }

        repository.saveAll(weeks);
    }

    private Week createWeek(ObjectId classroomId, LocalDate begin) {
        return Week.builder()
                .beginDate(begin)
                .classroomId(classroomId)
                .visible(false)
                .build();
    }

}
