package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.domain.Folder;
import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driver.folder.PatchFolderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatchFolderUS implements PatchFolderPort {

    private final FindFolderByIdUS findFolderByIdUS;
    private final FolderRepositoryPort repository;


    @Override
    public Folder execute(String folderId, Folder folder) {
        var dbFolder = findFolderByIdUS.execute(folderId, Folder.class);

//        getMapper().map(folder, dbFolder);

        return repository.save(dbFolder);
    }
}
