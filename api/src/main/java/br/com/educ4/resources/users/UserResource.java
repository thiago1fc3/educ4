package br.com.educ4.resources.users;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driver.user.CreateUserPort;
import br.com.educ4.core.ports.driver.user.EnableUserPort;
import br.com.educ4.core.ports.driver.user.PatchUserPort;
import br.com.educ4.core.ports.driver.user.SearchUserPort;
import br.com.educ4.resources.users.request.PatchUserRequest;
import br.com.educ4.resources.users.response.DefaultUserResponse;
import br.com.educ4.resources.users.response.SearchUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource {

    private final CreateUserPort createUserPort;
    private final PatchUserPort patchUserPort;
    private final EnableUserPort enableUserPort;
    private final SearchUserPort searchUserPort;

    @GetMapping("create")
    public DefaultUserResponse post(@AuthenticationPrincipal OAuth2User user){
        var localUser = User.builder()
                .name(user.getAttribute("name").toString())
                .username(user.getAttribute("email"))
                .picture(user.getAttribute("picture"))
                .build();

        localUser = createUserPort.execute(localUser);

        return DefaultUserResponse.fromUser(localUser);

    }

    @GetMapping("search")
    public List<SearchUserResponse> search(@PathParam("q") String q){
        var response =  searchUserPort.execute(q);

        return response
                .stream()
                .map(u -> SearchUserResponse.fromUser(u))
                .collect(Collectors.toList());
    }

    // TODO Pegar o id do usuário pelo token
    @PatchMapping("{id}")
    public DefaultUserResponse patch(@PathVariable String id, @RequestBody PatchUserRequest request){
        var user = request.toUser(id);
        var response = patchUserPort.execute(user.getId(), user);
        return DefaultUserResponse.fromUser(response);
    }


    @PatchMapping("{id}/enable")
    public DefaultUserResponse enable(@PathVariable String id){
        var response = enableUserPort.execute(id, true);
        return DefaultUserResponse.fromUser(response);
    }

    @PatchMapping("{id}/disable")
    public DefaultUserResponse disable(@PathVariable String id){
        var response = enableUserPort.execute(id, false);
        return DefaultUserResponse.fromUser(response);
    }

}
