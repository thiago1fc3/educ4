package br.com.educ4.core.userstory.auth;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.security.GenerateJWTPort;
import br.com.educ4.core.ports.driven.security.GetUserByGooglePort;
import br.com.educ4.core.ports.driver.auth.LoginByGooglePort;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.ports.driver.user.ExistsUserByUsernamePort;
import br.com.educ4.core.ports.driver.user.FindUserByUsernamePort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

import static java.util.Objects.isNull;

@Named
@RequiredArgsConstructor
public class LoginByGoogleUS implements LoginByGooglePort {

    private final GetUserByGooglePort getUserByGooglePort;
    private final ExistsUserByUsernamePort existsUserByUsernamePort;
    private final GenerateJWTPort generateJWTPort;
    private final FindUserByUsernamePort findUserByUsernamePort;
    private final CreateUserPort createUserPort;

    @Override
    public String execute(String token, String fingerprint) {

        var user = getUserByGooglePort.execute(token);

        if (isNull(user))
            throw new IllegalArgumentException("User not is valid!");

        var existsUser = existsUserByUsernamePort.execute(user.getUsername());

        if (!existsUser) {
            user = createUserPort.execute(user);
        } else {
            user = findUserByUsernamePort.execute(user.getUsername(), User.class);
        }

        if (!user.isEnabled()) {
            throw new IllegalArgumentException("User not is enabled!");
        }

        return generateJWTPort.execute(user, fingerprint);

    }
}
