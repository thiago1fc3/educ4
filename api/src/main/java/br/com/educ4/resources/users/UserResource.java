package br.com.educ4.resources.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.userstory.user.CreateUserUS;
import br.com.educ4.core.userstory.user.UpdateUserUS;
import br.com.educ4.resources.users.response.UserCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource {

    private final CreateUserUS createUserUS;
    private final UpdateUserUS updateUserUS;

    @GetMapping("create")
    public UserCreateResponse createUser(@AuthenticationPrincipal OAuth2User user){

        var localUser = User.builder()
                .name(user.getAttribute("name").toString())
                .username(user.getAttribute("email"))
                .picture(user.getAttribute("picture"))
                .build();

        localUser = createUserUS.execute(localUser);

        return UserCreateResponse.fromUser(localUser);

    }
    
    @PostMapping("update")
    public UserCreateResponse updateUser(@RequestBody Map<String, Object> user){
        System.out.println(">>>>>>");
        var localUser = User.builder()
                .id(user.getOrDefault("id", "").toString())
                .name(user.getOrDefault("name", "").toString())
                .picture(user.getOrDefault("picture", "").toString())
                .build();
        updateUserUS.execute(localUser.getId(), localUser);

        return UserCreateResponse.fromUser(localUser);
    }

}
