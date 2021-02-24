package br.com.educ4.core.ports.driven.repository.folder;

import br.com.educ4.core.domain.Folder;
import org.bson.types.ObjectId;

import java.util.Optional;
import java.util.Set;

public interface FolderRepositoryPort {

    Folder save(Folder folder);

    <T> Optional<T> findById(String id, Class<T> projection);

    <T> Set<T> findByUserId(ObjectId userId, Class<T> projection);

}
