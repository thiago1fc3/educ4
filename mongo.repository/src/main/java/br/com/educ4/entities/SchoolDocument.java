package br.com.educ4.entities;

import br.com.educ4.core.domain.School;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document("schools")

public class SchoolDocument {

    private String id;
    private String name;

    public static SchoolDocument fromSchool(School school) {
        return SchoolDocument.builder()
                .id(school.getId())
                .name(school.getName())
                .build();
    }

    public School toSchool(School school) {
        school.setId(id);
        school.setName(name);

        return school;
    }

}
