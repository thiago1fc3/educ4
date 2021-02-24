package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.FolderClassroom;
import org.bson.types.ObjectId;

public interface AddClassroomToFolderPort {

    FolderClassroom execute(ObjectId folderId, ObjectId classroomId);

}
