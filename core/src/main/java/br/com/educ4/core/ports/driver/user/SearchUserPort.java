package br.com.educ4.core.ports.driver.user;

import java.util.List;

public interface SearchUserPort {
    <T> List<T> execute(String q, Class<T> projection);
}
