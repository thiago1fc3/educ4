package br.com.educ4.resources.schools.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class IdsRequest {

    private Set<String> ids;

}
