package br.com.educ4.core.userstory.week;

import br.com.educ4.core.ports.driven.repository.week.WeekRepositoryPort;
import br.com.educ4.core.ports.driver.week.GetWeeksByClassroomIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetWeeksByClassroomIdUS implements GetWeeksByClassroomIdPort {

    private final WeekRepositoryPort repository;

    @Override
    public <T> List<T> execute(ObjectId classroomId, Class<T> projection) {
        return repository.findByClassroomId(classroomId, projection);
    }
}
