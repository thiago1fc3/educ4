package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driver.folder.DeleteFolderByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteFolderByIdUS implements DeleteFolderByIdPort {

    private final FolderRepositoryPort repository;

    @Override
    public void execute(String folderId) {
        repository.deleteById(folderId);
    }
}
