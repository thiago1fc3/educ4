package br.com.educ4.core.ports.driver.folder;

import br.com.educ4.core.domain.Folder;

public interface CreateFolderPort {

    // TODO ver qual parâmetro a ser passado na criação da pasta
    Folder execute(String userId, Folder folder);
}
