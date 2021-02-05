package br.com.educ4.controller.users.response;

import br.com.educ4.core.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefaultUserResponse {

    private final String id;

    public static DefaultUserResponse fromUser(User user){
        return DefaultUserResponse.builder()
                .id(user.getId())
                .build();
    }
}
