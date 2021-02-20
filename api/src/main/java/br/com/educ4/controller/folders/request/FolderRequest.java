package br.com.educ4.controller.folders.request;

import br.com.educ4.core.domain.Folder;
import lombok.Setter;

@Setter
public class FolderRequest {

    private String name;

    public Folder toFolder() {
        return Folder.builder()
                .name(name)
                .build();
    }
}
