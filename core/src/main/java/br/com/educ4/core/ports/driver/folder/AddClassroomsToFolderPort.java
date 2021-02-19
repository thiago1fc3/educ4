package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.Folder;

public interface AddClassroomsToFolderPort {

    Folder execute(String folderId, String classroomsIds);
}
