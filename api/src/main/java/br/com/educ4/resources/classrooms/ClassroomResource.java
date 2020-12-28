package br.com.educ4.resources.classrooms;

import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdPort;
import br.com.educ4.core.ports.driver.classroom.GetAllClassroomsPort;
import br.com.educ4.core.ports.driver.classroom.PatchClassroomPort;
import br.com.educ4.resources.classrooms.request.ClassroomRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/classrooms")
@RequiredArgsConstructor
public class ClassroomResource {

    private final CreateClassroomPort createClassroomPort;
    private final PatchClassroomPort patchClassroomPort;
    private final FindClassroomByIdPort findClassroomByIdPort;
    private final GetAllClassroomsPort getAllClassroomsPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable String schoolId, @RequestBody ClassroomRequest request) {
        var response = createClassroomPort.execute(schoolId, request.toClassroom());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{classroomId}")
    public Map<String, Object> patch(@PathVariable String schoolId, @PathVariable String classroomId, @RequestBody ClassroomRequest request) {
        var response = patchClassroomPort.execute(classroomId, request.toClassroom());
        return Map.of("id", response.getId());
    }

    @GetMapping
    public List<Classroom> getAll(@PathVariable String schoolId) {
        return getAllClassroomsPort.execute();
    }

    @GetMapping("{classroomId}")
    public Classroom getById(@PathVariable String schoolId, @PathVariable String classroomId) {
        return findClassroomByIdPort.execute(classroomId);
    }
}
