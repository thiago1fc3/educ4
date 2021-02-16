package br.com.educ4.controller.folders;

import br.com.educ4.controller.schools.request.IdsRequest;
import br.com.educ4.core.ports.driver.folder.AddClassroomsToFolderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("folders/{folderId}/classrooms")
@RequiredArgsConstructor
public class FolderClassroomController {
    private final AddClassroomsToFolderPort addClassroomsToFolderPort;

    @PatchMapping
    public Map<String, Object> patch(@PathVariable String folderId, @RequestBody IdsRequest request) {
        var response = addClassroomsToFolderPort.execute(folderId, request.getIds());
        return Map.of("id", response.getId());
    }
}
