package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Folder {
    private String id;
    private String name;

    private String userId;
    private Set<String> classroomsIds;

    public void addClassrooms(Set<String> classroomsIds) {
        if (Objects.isNull(this.classroomsIds))
            this.classroomsIds = new HashSet<>();

        this.classroomsIds.addAll(classroomsIds);
    }
}
