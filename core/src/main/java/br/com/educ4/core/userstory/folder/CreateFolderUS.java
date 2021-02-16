package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.domain.Folder;
import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driver.folder.CreateFolderPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateFolderUS implements CreateFolderPort {
    private final FolderRepositoryPort repository;

    @Override
    public Folder execute(String userId, Folder folder) {
        folder.setUserId(userId);
        return repository.save(folder);
    }
}
