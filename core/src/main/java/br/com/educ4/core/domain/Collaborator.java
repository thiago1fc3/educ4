package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class Collaborator {

    private boolean admin;
    private LocalDateTime dateTime;
    private String professorId;

    public static Collaborator create() {
        return Collaborator.builder()
                .dateTime(LocalDateTime.now())
                .build();
    }

}
