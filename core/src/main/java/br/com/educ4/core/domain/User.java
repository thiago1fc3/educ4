package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Accessors(chain = true)
@Document
public class User extends AbstractEntity {

    private String username;
    private String name;
    private String picture;
    private boolean admin;
    private boolean enabled;

}

