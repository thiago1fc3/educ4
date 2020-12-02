package br.com.educ4.core.ports.driven.repository.user;

public interface ExitsUserByUsernameRepositoryPort {
    public boolean execute(String username);
}
