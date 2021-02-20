package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(of = "id")
@Document
public class Folder {

    private String id;
    private String name;

    @Indexed
    private ObjectId userId;

}
