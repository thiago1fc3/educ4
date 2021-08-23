package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import br.com.educ4.core.ports.driver.week.CreateWeeksByRangeDatePort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClassroomUS implements CreateClassroomPort {

    private final ClassroomRepositoryPort repository;
    //    private final AuthUserPort authUserPort;
    private final CreateWeeksByRangeDatePort createWeeks;

    @Override
    public Classroom execute(ObjectId schoolId, Classroom classroom) {

        classroom.setSchoolId(schoolId);
        classroom = repository.save(classroom);

//        var collaborator = Collaborator.create()
//                .setAdmin(true)
//                .setUserId(authUserPort.getUserId())
//                .setClassroomId(new ObjectId(classroom.getId()));

        createWeeks.execute(
                new ObjectId(classroom.getId()),
                classroom.getBeginDate(),
                classroom.getEndDate()
        );

        return classroom;
    }

}
