package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final String id;
    private final String username;
    private final String name;
    private final String picture;
}
