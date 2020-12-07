package br.com.educ4.resources.users.response;

import br.com.educ4.core.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchUserResponse {
    private final String id;
    private final String username;
    private final String picture;
    private final boolean enabled;

    public static SearchUserResponse fromUser(User user){
        return SearchUserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .picture(user.getPicture())
                .enabled(user.isEnabled())
                .build();
    }
}
