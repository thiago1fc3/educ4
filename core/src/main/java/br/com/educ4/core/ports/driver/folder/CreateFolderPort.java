package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.Folder;

public interface CreateFolderPort {

    Folder execute(Folder folder);
}
