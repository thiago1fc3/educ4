package br.com.educ4.core.ports.driver.user;

import br.com.educ4.core.ports.driven.security.AuthUserIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class GetMyUserPortUS implements GetMyUserPort {

    private final AuthUserIdPort authUserIdPort;
    private final FindUserByIdPort findUserByIdPort;

    @Override
    public <T> T execute(Class<T> projection) {
        return findUserByIdPort.execute(authUserIdPort.getUserId(), projection);
    }

}
