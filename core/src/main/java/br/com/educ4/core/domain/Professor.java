package br.com.educ4.core.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Professor {
    private String id;
    private String userId;
}
