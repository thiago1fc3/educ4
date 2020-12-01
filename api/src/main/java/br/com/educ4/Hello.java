package br.com.educ4;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping
@RestController
public class Hello {
    @GetMapping("me")
    public OAuth2User getMe(@AuthenticationPrincipal OAuth2User user){
        return user;
    }

    @GetMapping("me2")
    public User getMe2(@AuthenticationPrincipal OAuth2User user){
        var id = UUID.randomUUID().toString();
        var name = user.getAttribute("name").toString();
        var picture = user.getAttribute("picture").toString();
        var email = user.getAttribute("email").toString();
        return new User(id, name, email, picture);
    }
}
