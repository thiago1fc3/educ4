package br.com.educ4.resources.users.response;

import br.com.educ4.core.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateResponse {

    private final String id;
    private final String name;
    private final String email;
    private final String picture;

    public static UserCreateResponse fromUser(User user){
        return UserCreateResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getUsername())
                .picture(user.getPicture())
                .build();
    }
}
