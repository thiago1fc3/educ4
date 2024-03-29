package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.domain.Folder;
import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driven.security.AuthUserIdPort;
import br.com.educ4.core.ports.driver.folder.CreateFolderPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFolderUS implements CreateFolderPort {

    private final FolderRepositoryPort repository;
    private final AuthUserIdPort authUserIdPort;

    @Override
    public Folder execute(String userId, Folder folder) {
        var id = new ObjectId(userId);
        folder.setUserId(id);
        return repository.save(folder);
    }

}
