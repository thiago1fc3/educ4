package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@Document
public class FolderClassroom {

    private String id;

    @Indexed
    private ObjectId classroomId;

    @Indexed
    private ObjectId folderId;

    @Indexed
    private ObjectId userId;

}
