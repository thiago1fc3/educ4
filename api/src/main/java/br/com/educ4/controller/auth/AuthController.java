package br.com.educ4.controller.auth;

import br.com.educ4.tokens.GetJwsClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.http.HttpHeaders.USER_AGENT;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final HttpServletRequest request;

//    @PostMapping
//    public String auth() {
//
//        var user = repository.findByUsername("admin@admin.com", AuthUser.class);
//
//        return GenerateToken.execute(user.get().getId(), request.getHeader(USER_AGENT));
//    }

    @GetMapping("me")
    public Object me(String token) {
        var jws = GetJwsClaims.execute(5, request.getHeader(USER_AGENT), token);
        return jws.getBody().get("user", Map.class).get("id");
    }
}
