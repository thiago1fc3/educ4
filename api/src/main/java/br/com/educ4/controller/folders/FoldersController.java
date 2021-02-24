package br.com.educ4.controller.folders;

import br.com.educ4.controller.folders.request.FolderRequest;
import br.com.educ4.controller.folders.responses.FolderResponse;
import br.com.educ4.core.ports.driven.security.AuthUserPort;
import br.com.educ4.core.ports.driver.folder.AddClassroomToFolderPort;
import br.com.educ4.core.ports.driver.folder.CreateFolderPort;
import br.com.educ4.core.ports.driver.folder.FindFolderByUserIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("folders")
@RequiredArgsConstructor
public class FoldersController {

    private final CreateFolderPort createFolderPort;
    private final FindFolderByUserIdPort findFolderByUserIdPort;
    private final AddClassroomToFolderPort addClassroomToFolderPort;
    private final AuthUserPort authUserPort;

    @PostMapping
    public Map<String, Object> post(@RequestBody FolderRequest request) {
        var response = createFolderPort.execute(request.toFolder());
        return Map.of("id", response.getId());
    }

    @PatchMapping("{folderId}/classrooms/{classroomId}/add-to-folder")
    public Map<String, Object> addClassroomToFolder(@PathVariable ObjectId folderId, @PathVariable ObjectId classroomId) {
        var response = addClassroomToFolderPort.execute(folderId, classroomId);
        return Map.of("id", response.getId());
    }

    @GetMapping
    public Set<FolderResponse> post() {
        return findFolderByUserIdPort.execute(authUserPort.getUserId(), FolderResponse.class);
    }
}
