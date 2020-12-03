package br.com.educ4.entities;

import br.com.educ4.core.domain.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document("users")
public class UserDocument {

    private String id;
    private String username;
    private String name;
    private String picture;

    public static UserDocument fromUser(User user){
        return UserDocument.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .picture(user.getPicture())
                .build();
    }
}
