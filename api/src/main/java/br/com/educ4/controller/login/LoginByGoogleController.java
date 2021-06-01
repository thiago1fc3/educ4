package br.com.educ4.controller.login;

import br.com.educ4.controller.login.requests.TokenRequest;
import br.com.educ4.core.ports.driver.auth.LoginByGooglePort;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("auth/google")
@RequiredArgsConstructor
public class LoginByGoogleController {

    private final LoginByGooglePort loginPort;
    private final HttpServletRequest http;

    @PostMapping
    public String post(@RequestBody TokenRequest request) {
        var userAgent = http.getHeader(HttpHeaders.USER_AGENT);
        return loginPort.execute(request.getToken(), userAgent);
    }

}
