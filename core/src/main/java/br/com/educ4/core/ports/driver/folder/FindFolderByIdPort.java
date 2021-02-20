package br.com.educ4.core.ports.driver.folder;

public interface FindFolderByIdPort {
    <T> T execute(String id, Class<T> projection);
}
