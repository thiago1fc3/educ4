package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.domain.Folder;
import br.com.educ4.core.ports.driven.repository.folder.FolderRepositoryPort;
import br.com.educ4.core.ports.driven.security.AuthUserIdPort;
import br.com.educ4.core.ports.driver.folder.CreateFolderPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateFolderUS implements CreateFolderPort {

    private final FolderRepositoryPort repository;
//    private final AuthUserIdPort authUserIdPort;

    @Override
    public Folder execute(Folder folder) {
//        folder.setUserId(authUserIdPort.getUserId());
        return repository.save(folder);
    }

}
