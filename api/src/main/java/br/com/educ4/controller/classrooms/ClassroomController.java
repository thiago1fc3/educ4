package br.com.educ4.controller.classrooms;

import br.com.educ4.controller.classrooms.request.ClassroomRequest;
import br.com.educ4.core.domain.Classroom;
import br.com.educ4.core.ports.driver.classroom.CreateClassroomPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByIdPort;
import br.com.educ4.core.ports.driver.classroom.GetAllClassroomsPort;
import br.com.educ4.core.ports.driver.classroom.PatchClassroomPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schools/{schoolId}/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final CreateClassroomPort createClassroomPort;
    private final PatchClassroomPort patchClassroomPort;
    private final FindClassroomByIdPort findClassroomByIdPort;
    private final GetAllClassroomsPort getAllClassroomsPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable String schoolId, @RequestBody ClassroomRequest request) {
        // TODO modificar o id do professor para pegar automaticamente do usuário logado
        var response = createClassroomPort.execute(schoolId, "60180378b82dae580236f108", request.toClassroom());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{classroomId}")
    public Map<String, Object> patch(@PathVariable String schoolId, @PathVariable String classroomId, @RequestBody ClassroomRequest request) {
        var response = patchClassroomPort.execute(classroomId, request.toClassroom());
        return Map.of("id", response.getId());
    }

    @GetMapping("{userId}")
    public List<Classroom> getAll(@PathVariable String schoolId, @PathVariable String userId) {
        return getAllClassroomsPort.execute(Classroom.class);
    }

    @GetMapping("{classroomId}")
    public Classroom getById(@PathVariable String schoolId, @PathVariable String classroomId) {
        return findClassroomByIdPort.execute(classroomId, Classroom.class);
    }
}
