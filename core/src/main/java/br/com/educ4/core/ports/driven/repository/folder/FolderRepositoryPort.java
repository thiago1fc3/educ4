package br.com.educ4.core.ports.driven.repository.folder;

import br.com.educ4.core.domain.Folder;

import java.util.List;
import java.util.Optional;

public interface FolderRepositoryPort {

    Folder save(Folder folder);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> List<T> findBy(Class<T> projection);
}
