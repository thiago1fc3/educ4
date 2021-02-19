package br.com.educ4.controller.auth;

import br.com.educ4.AuthUser;
import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.ports.driver.user.ExistsUserByUsernamePort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("auth/google")
@RequiredArgsConstructor
public class AuthGoogleController {

    private final AuthUser authUser;
    private final CreateUserPort createUserPort;
    private final FindUserByUsernamePort findUserByUsernamePort;

    private final ExistsUserByUsernamePort existsUserByUsernamePort;

    @PostMapping
    public User auth() throws GeneralSecurityException, IOException {

        var user = authUser.getUser();

        if (nonNull(user)) {

            var existsUser = existsUserByUsernamePort.execute(user.getUsername());

            if (!existsUser) {
                return createUserPort.execute(user);
            }

            return findUserByUsernamePort.execute(user.getUsername(), User.class);

        }

        return null;
    }
}
