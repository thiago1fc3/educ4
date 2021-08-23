package br.com.educ4.controller.users.request;

import br.com.educ4.core.domain.User;
import lombok.Setter;

@Setter
public class PatchUserRequest {

    private String name;
    private String picture;

    public User toUser(String id) {

        var user = User.builder()
                .name(name)
                .picture(picture)
                .build();

        user.setId(id);

        return user;
    }
}
