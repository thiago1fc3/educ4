package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode(of = "id")
public class User {
    private String id;
    private final String username;
    private final String name;
    private final String picture;

    public void setId(String id){
        this.id = id;
    }
}
