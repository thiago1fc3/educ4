package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.Folder;

public interface PatchFolderPort {
    Folder execute(String folderId, Folder folder);
}
