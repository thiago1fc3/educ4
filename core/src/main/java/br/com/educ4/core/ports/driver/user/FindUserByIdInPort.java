package br.com.educ4.core.ports.driver.user;

import java.util.Set;

public interface FindUserByIdInPort {
    <T> Set<T> execute(Set<String> ids, Class<T> projection);
}
