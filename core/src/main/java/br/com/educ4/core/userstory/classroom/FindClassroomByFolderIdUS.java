package br.com.educ4.core.userstory.classroom;

import br.com.educ4.core.ports.driven.repository.classroom.ClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.classroom.FindClassroomByFolderIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class FindClassroomByFolderIdUS implements FindClassroomByFolderIdPort {

    private final ClassroomRepositoryPort repository;

    @Override
    public <T> List<T> execute(ObjectId folderId, Class<T> projection) {
        return repository.findByFolderId(folderId, projection);
    }
}
