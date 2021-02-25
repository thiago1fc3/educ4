package br.com.educ4.controller.schools.request;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Set;

@Setter
@Getter
public class IdsRequest {

    private Set<ObjectId> ids;

}
