package br.com.educ4.controller.users.response;

import br.com.educ4.core.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserMeResponse {

    private final String username;
    private final String picture;
    private final boolean enabled;

    public static UserMeResponse fromUser(User user) {
        return UserMeResponse.builder()
                .username(user.getUsername())
                .picture(user.getPicture())
                .enabled(user.isEnabled())
                .build();
    }
}
