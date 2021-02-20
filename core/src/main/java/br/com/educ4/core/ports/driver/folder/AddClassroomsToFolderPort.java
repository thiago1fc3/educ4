package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.Folder;
import org.bson.types.ObjectId;

public interface AddClassroomsToFolderPort {

    Folder execute(ObjectId folderId, ObjectId classroomsIds);
}
