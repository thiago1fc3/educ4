package br.com.educ4;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.security.UserPermissionPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPermission implements UserPermissionPort {

    private final AuthUserId authUserId;
    private final FindUserByIdPort findUserByIdPort;

    public boolean isAdmin(String userId) {
        var user = findUserByIdPort.execute(userId, User.class);
        return user.isAdmin();
    }

}
