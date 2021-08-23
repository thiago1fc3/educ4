package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driven.security.AuthUserIdPort;
import br.com.educ4.core.ports.driver.folder.GetMyFoldersPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetMyFoldersUS implements GetMyFoldersPort {

    private final FolderRepositoryPort repository;
    private final AuthUserIdPort authUserIdPort;

    public <T> Set<T> execute(String userId, Class<T> projection) {
        var id = new ObjectId(userId);
        return repository.findByUserId(id, projection);
    }
}
