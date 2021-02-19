package br.com.educ4.controller.users;

import br.com.educ4.controller.folders.request.FolderRequest;
import br.com.educ4.core.ports.driver.folder.CreateFolderPort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users/{userId}/folders")
@RequiredArgsConstructor
public class UserFolderController {

    private final FindUserByUsernamePort findUserByUsernamePort;
    private final CreateFolderPort createFolderPort;

    @PostMapping
    public Map<String, Object> post(@PathVariable String userId, @RequestBody FolderRequest request) {
        var response = createFolderPort.execute(userId, request.toFolder());
        return Map.of("id", response.getId());
    }
}
