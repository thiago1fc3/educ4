package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.PatchClassroomPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static br.com.educ4.core.utils.MapperConfig.getMapper;

@Named
@RequiredArgsConstructor
public class PatchClassroomUS implements PatchClassroomPort {

    private final FindClassroomByIdUS findClassroomByIdUS;
    private final ClassroomRepositoryPort repository;

    @Override
    public Classroom execute(String classroomId, Classroom classroom) {
        var dbClassroom = findClassroomByIdUS.execute(classroomId);

        getMapper().map(classroom, dbClassroom);

        return repository.save(dbClassroom);
    }
}
