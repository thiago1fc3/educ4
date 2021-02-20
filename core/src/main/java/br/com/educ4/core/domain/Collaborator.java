package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@Document
public class Collaborator {

    private boolean admin;
    private LocalDateTime dateTime;

    @Indexed
    private ObjectId professorId;

    public static Collaborator create() {
        return Collaborator.builder()
                .dateTime(LocalDateTime.now())
                .build();
    }

}
