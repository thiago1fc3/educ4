package br.com.educ4.core.domain.exceptions;

import java.time.LocalDateTime;

public class DomainException extends RuntimeException {

    private Status status;
    private LocalDateTime timestamp;

    public DomainException(String msg, Status status) {
        super(msg);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public DomainException(String msg, Status status, Throwable cause) {
        super(msg, cause);
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public Status status() {
        return status;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }
}
