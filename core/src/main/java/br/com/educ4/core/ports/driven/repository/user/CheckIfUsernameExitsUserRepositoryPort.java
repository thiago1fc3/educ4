package br.com.educ4.core.ports.driven.repository.user;

public interface CheckIfUsernameExitsUserRepositoryPort {
    public boolean execute(String username);
}
