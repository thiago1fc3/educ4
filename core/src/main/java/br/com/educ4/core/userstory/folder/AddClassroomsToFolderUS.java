package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.domain.Folder;
import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driver.folder.AddClassroomsToFolderPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.Set;

@Named
@RequiredArgsConstructor
public class AddClassroomsToFolderUS implements AddClassroomsToFolderPort {

    private final FindFolderByIdUS findFolderByIdUS;
    private final FolderRepositoryPort repository;

    @Override
    public Folder execute(String folderId, Set<String> classroomsIds) {
        var dbFolder = findFolderByIdUS.execute(folderId, Folder.class);
        dbFolder.addClassrooms(classroomsIds);
        return repository.save(dbFolder);
    }
}
