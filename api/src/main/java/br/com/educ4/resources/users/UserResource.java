package br.com.educ4.resources.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.userstory.user.CreateUserUS;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource {

    private final CreateUserUS createUserUS;

    @GetMapping
    public User createUser(@AuthenticationPrincipal OAuth2User user){

        var localUser = User.builder()
                .name(user.getAttribute("name").toString())
                .username(user.getAttribute("email"))
                .picture(user.getAttribute("picture"))
                .build();

        return createUserUS.execute(localUser);
    }

}
