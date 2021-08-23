package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.PatchClassroomPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatchClassroomUS implements PatchClassroomPort {

    private final FindClassroomByIdAndSchoolIdAndSchoolIdUS findClassroomByIdAndSchoolIdUS;
    private final ClassroomRepositoryPort repository;

    @Override
    public Classroom execute(String classroomId, ObjectId schoolId, Classroom classroom) {
        var dbClassroom = findClassroomByIdAndSchoolIdUS.execute(classroomId, schoolId, Classroom.class);

//        getMapper().map(classroom, dbClassroom);

        return repository.save(dbClassroom);
    }
}
