package br.com.educ4.controller.classrooms;

import br.com.educ4.controller.classrooms.request.ClassroomRequest;
import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdAndSchoolIdPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomBySchoolIdPort;
import br.com.educ4.core.ports.driver.classroom.PatchClassroomPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final CreateClassroomPort createClassroomPort;
    private final PatchClassroomPort patchClassroomPort;
    private final FindClassroomByIdAndSchoolIdPort findClassroomByIdAndSchoolIdPort;
    private final FindClassroomBySchoolIdPort findClassroomBySchoolIdPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable ObjectId schoolId, @RequestBody ClassroomRequest request) {
        var response = createClassroomPort.execute(schoolId, request.toClassroom());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{classroomId}")
    public void patch(@PathVariable ObjectId schoolId, @PathVariable String classroomId, @RequestBody ClassroomRequest request) {
        patchClassroomPort.execute(classroomId, schoolId, request.toClassroom());
    }

    @GetMapping
    public List<Classroom> getMy(@PathVariable ObjectId schoolId) {
        return findClassroomBySchoolIdPort.execute(schoolId, Classroom.class);
    }

    @GetMapping("{classroomId}")
    public Classroom getById(@PathVariable ObjectId schoolId, @PathVariable String classroomId) {
        return findClassroomByIdAndSchoolIdPort.execute(classroomId, schoolId, Classroom.class);
    }
}
