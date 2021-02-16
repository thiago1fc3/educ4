package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.Folder;

import java.util.Set;

public interface AddClassroomsToFolderPort {

    Folder execute(String folderId, Set<String> classroomsIds);
}
