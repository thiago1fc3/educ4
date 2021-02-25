package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driver.folder.FindFolderByUserIdPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;

import javax.inject.Named;
import java.util.Set;

@Named
@RequiredArgsConstructor
public class FindFolderByUserIdUs implements FindFolderByUserIdPort {

    private final FolderRepositoryPort repository;

    @Override
    public <T> Set<T> execute(ObjectId userId, Class<T> projection) {
        return repository.findByUserId(userId, projection);
    }

}
