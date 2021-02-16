package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driver.folder.FindFolderByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.NoSuchElementException;

@Named
@RequiredArgsConstructor
public class FindFolderByIdUS implements FindFolderByIdPort {

    private final FolderRepositoryPort repository;

    public <T> T execute(String id, Class<T> projection) {
        return repository.findById(id, projection).orElseThrow(() -> new NoSuchElementException("Folder not found!"));
    }
}
