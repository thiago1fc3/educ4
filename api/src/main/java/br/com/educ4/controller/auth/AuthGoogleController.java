package br.com.educ4.controller.auth;

import br.com.educ4.AuthUser;
import br.com.educ4.controller.auth.responses.ProfileResponse;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.ports.driver.user.ExistsUserByUsernamePort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import lombok.RequiredArgsConstructor;
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
    public ProfileResponse auth() throws GeneralSecurityException, IOException {

        var authUser = this.authUser.getUser();

        if (nonNull(authUser)) {

            var existsUser = existsUserByUsernamePort.execute(authUser.getUsername());

            if (!existsUser) {
                createUserPort.execute(authUser);
            }

            var user = findUserByUsernamePort.execute(authUser.getUsername(), ProfileResponse.class);

            if (!authUser.isEnabled()) {
                throw new IllegalArgumentException("User not is enabled!");
            }

            return user;

        }

        throw new IllegalArgumentException("User not is valid!");
    }
}
