package br.com.educ4.controller.login;

import br.com.educ4.controller.login.requests.TokenRequest;
import br.com.educ4.core.ports.driver.auth.LoginByGooglePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/google")
@RequiredArgsConstructor
public class LoginByGoogleController {

    private final LoginByGooglePort loginPort;

    @PostMapping
    public String post(@RequestBody TokenRequest request, @RequestHeader("userAgent") String userAgent) {
        return loginPort.execute(request.getToken(), userAgent);
    }

}
