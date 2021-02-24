package br.com.educ4.repository;

import br.com.educ4.core.domain.FolderClassroom;
import br.com.educ4.core.ports.driven.repository.folder.FolderClassroomRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FolderClassroomRepository extends MongoRepository<FolderClassroom, String>, FolderClassroomRepositoryPort {
}
