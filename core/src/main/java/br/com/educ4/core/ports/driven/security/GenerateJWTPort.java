package br.com.educ4.core.ports.driven.security;

import br.com.educ4.core.domain.User;

public interface GenerateJWTPort {
    String execute(User user, String fingerprint);
}