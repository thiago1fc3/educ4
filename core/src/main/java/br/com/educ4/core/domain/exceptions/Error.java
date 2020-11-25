package br.com.educ4.core.domain.exceptions;

import static br.com.educ4.core.domain.exceptions.Status.*;

public class Error {

    public static void required(String field){
        throw new DomainException(String.format("%s is required", field), REQUIRED);
    }

    public static void notFound(String field) {
        throw new DomainException(String.format("%s not found", field), NOT_FOUND);
    }

    public static void already(String field) {
        throw new DomainException(String.format("%s already exists", field), ALREADY);
    }

    public static void invalidUser() {
        throw new DomainException(String.format("Username/password invalid!"), INVALID_USER);
    }
}
