package br.com.educ4.core.ports.driver.folder;

import java.util.Set;

public interface GetMyFoldersPort {
    <T> Set<T> execute(String userId, Class<T> projection);
}
