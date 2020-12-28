package br.com.educ4.core.userstory.user;

import br.com.educ4.core.domain.User;
import br.com.educ4.core.ports.driven.repository.user.FindUserBySearchRepositoryPort;
import br.com.educ4.core.ports.driver.user.SearchUserPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class SearchUserUS implements SearchUserPort {

    private final FindUserBySearchRepositoryPort findUserBySearchRepositoryPort;

    @Override
    public List<User> execute(String q) {
        return findUserBySearchRepositoryPort.execute(q);
    }
}
