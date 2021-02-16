package br.com.educ4.repository;

import br.com.educ4.core.domain.Folder;
import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FolderRepository extends MongoRepository<Folder, String>, FolderRepositoryPort {
}
