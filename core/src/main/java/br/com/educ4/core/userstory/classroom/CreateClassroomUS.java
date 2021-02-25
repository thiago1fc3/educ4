package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.domain.Collaborator;
import br.com.educ4.core.domain.Week;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driven.repository.weeks.WeekRepositoryPort;
import br.com.educ4.core.ports.driven.security.AuthUserPort;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateClassroomUS implements CreateClassroomPort {
    private final ClassroomRepositoryPort repository;
    private final WeekRepositoryPort weekRepositoryPort;
    private final AuthUserPort authUserPort;

    @Override
    public Classroom execute(ObjectId schoolId, Classroom classroom) {

        classroom.setSchoolId(schoolId);
        classroom = repository.save(classroom);

        var collaborator = Collaborator.create()
                .setAdmin(true)
                .setUserId(authUserPort.getUserId())
                .setClassroomId(new ObjectId(classroom.getId()));

        var date = classroom.getBeginDate();
        while (date.isBefore(classroom.getEndDate())) {
            var week = Week.builder()
                    .beginDate(date)
                    .classroomId(new ObjectId(classroom.getId()))
                    .visible(false)
                    .build();
            date = date.plusWeeks(1);

            weekRepositoryPort.save(week);
        }

        return classroom;
    }
}
