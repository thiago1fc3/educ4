package br.com.educ4.controller.users.request;

import br.com.educ4.core.domain.User;
import lombok.Setter;

@Setter
public class PatchUserRequest {

    private String name;
    private String picture;

    public User toUser(String id){
        return  User.builder()
                    .id(id)
                    .name(name)
                    .picture(picture)
                    .build();
    }
}
