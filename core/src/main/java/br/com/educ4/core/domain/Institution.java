package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
@Document
public class Institution {

    private String id;
    private String name;

}
