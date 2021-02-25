package br.com.educ4.core.ports.driver.folder;

import org.bson.types.ObjectId;

import java.util.Set;

public interface FindFolderByUserIdPort {
    <T> Set<T> execute(ObjectId userId, Class<T> projection);
}
