package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
@Document
public class School {

    private String id;
    private String name;

    @Indexed
    private ObjectId institutionId;

    @Indexed
    private Set<ObjectId> coordinatorsIds;

    public void addCoordinators(Set<ObjectId> coordinatorsIds) {
        if (Objects.isNull(this.coordinatorsIds))
            this.coordinatorsIds = new HashSet<>();

        this.coordinatorsIds.addAll(coordinatorsIds);
    }

    public void removeCoordinators(Set<ObjectId> coordinatorsIds) {
        if (Objects.nonNull(this.coordinatorsIds))
            this.coordinatorsIds.removeAll(coordinatorsIds);
    }

}
