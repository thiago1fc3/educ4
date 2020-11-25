package br.com.educ4.core.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static br.com.educ4.core.domain.exceptions.Error.required;
import static java.util.Objects.isNull;

public class User {

    private String id;
    private String username;
    private String password;
    private final BCryptPasswordEncoder encoder;
    private final Set<Permission> permissions;

    public User() {
        this.encoder = new BCryptPasswordEncoder();
        this.permissions = new HashSet<>();
    }


    // TODO test
    public User id(String id) {
        this.id = id;
        return this;
    }

    // TODO test
    public User username(String username) {
        this.username = username;
        return this;
    }

    // TODO test
    public User password(String password) {
        this.password = encoder.encode(password);
        return this;
    }

    // TODO test
    public User add(Permission permission) {
        if (isNull(permission))
            required("Permission");

        permissions.add(permission);
        return this;
    }

    // TODO testude
    
    public boolean matches(String rawPassword) {
        return encoder.matches(rawPassword, password());
    }

    public String id() {
        return id;
    }

    public String password() {
        return password;
    }

    public String username() {
        return username;
    }

    public boolean isAdmin() {
        return permissions.contains(Permission.ADMIN);
    }

    public enum Permission {
        ADMIN
    }
}
