package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class School {

    private String id;
    private String name;

    private String institutionId;
    private Set<String> coordinatorsIds;
    private Set<String> professorsIds;

    public void addCoordinators(Set<String> coordinatorsIds) {
        if(Objects.isNull(this.coordinatorsIds))
            this.coordinatorsIds = new HashSet<>();

        this.coordinatorsIds.addAll(coordinatorsIds);
    }

    public void removeCoordinators(Set<String> coordinatorsIds) {
        if(Objects.nonNull(this.coordinatorsIds))
            this.coordinatorsIds.removeAll(coordinatorsIds);
    }

    public void addProfessors(Set<String> professorsIds) {
        if(Objects.isNull(this.professorsIds))
            this.professorsIds = new HashSet<>();

        this.professorsIds.addAll(professorsIds);
    }

}
