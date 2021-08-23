package br.com.educ4.core.userstory.folder;

import br.com.educ4.core.domain.FolderClassroom;
import br.com.educ4.core.ports.driven.repository.folder.FolderClassroomRepositoryPort;
import br.com.educ4.core.ports.driver.folder.AddClassroomToFolderPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddClassroomToFolderUS implements AddClassroomToFolderPort {

    //    private final AuthUserIdPort authUserIdPort;
    private final FolderClassroomRepositoryPort repository;

    @Override
    public FolderClassroom execute(ObjectId folderId, ObjectId classroomId) {
        var folder = FolderClassroom.builder()
                .classroomId(classroomId)
                .folderId(folderId)
//                .userId(authUserIdPort.getUserId())
                .build();

        return repository.save(folder);
    }
}
