package br.com.educ4.controller.users;

import br.com.educ4.AuthUser;
import br.com.educ4.controller.users.request.PatchUserRequest;
import br.com.educ4.controller.users.response.DefaultUserResponse;
import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.EnableUserPort;
import br.com.educ4.core.ports.driver.user.FindUserByIdPort;
import br.com.educ4.core.ports.driver.user.PatchUserPort;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final AuthUser authUser;
    private final PatchUserPort patchUserPort;
    private final EnableUserPort enableUserPort;
    private final FindUserByIdPort findUserByIdPort;

    // TODO Pegar o id do usuário pelo token
    @PatchMapping("{id}")
    public DefaultUserResponse patch(@PathVariable String id, @RequestBody PatchUserRequest request) {
        var user = request.toUser(id);
        var response = patchUserPort.execute(user.getId(), user);
        return DefaultUserResponse.fromUser(response);
    }


    @PatchMapping("{id}/enable")
    public DefaultUserResponse enable(@PathVariable String id) {
        var response = enableUserPort.execute(id, true);
        return DefaultUserResponse.fromUser(response);
    }

    @PatchMapping("{id}/disable")
    public DefaultUserResponse disable(@PathVariable String id) {
        var response = enableUserPort.execute(id, false);
        return DefaultUserResponse.fromUser(response);
    }

    @GetMapping("{id}/me")
    public User getById(@PathVariable String id) {
        return findUserByIdPort.execute(id, User.class);
    }

    @GetMapping("me")
    public User me() throws GeneralSecurityException, IOException {
        return authUser.getUser();
    }
}
