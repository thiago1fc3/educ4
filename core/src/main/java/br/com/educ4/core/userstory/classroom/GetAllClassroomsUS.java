package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.GetAllClassroomsPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class GetAllClassroomsUS implements GetAllClassroomsPort {

    private final ClassroomRepositoryPort repository;

    public List<Classroom> execute() {
        return repository.findAll();
    }

}
