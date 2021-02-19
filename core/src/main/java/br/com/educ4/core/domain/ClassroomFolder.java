package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class ClassroomFolder {

    private String folderId;
    private String userId;

}
