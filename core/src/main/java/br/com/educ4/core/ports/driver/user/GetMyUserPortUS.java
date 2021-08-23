package br.com.educ4.core.ports.driver.user;

import br.com.educ4.core.ports.driven.security.AuthUserIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMyUserPortUS implements GetMyUserPort {

    private final AuthUserIdPort authUserIdPort;
    private final FindUserByIdPort findUserByIdPort;

    @Override
    public <T> T execute(String userId, Class<T> projection) {
        return findUserByIdPort.execute(userId, projection);
    }

}
