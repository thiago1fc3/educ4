package br.com.educ4.controller.users;

import br.com.educ4.controller.users.response.UserMeResponse;
import br.com.educ4.core.ports.driver.user.GetMyUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/me")
@RequiredArgsConstructor
public class MyUserController {

    private final GetMyUserPort getMyUserPort;

    @GetMapping
    public UserMeResponse me() {
        return getMyUserPort.execute(UserMeResponse.class);
    }

}
