package br.com.educ4.exceptions;

import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class HttpErrorInfo {
    private final ZonedDateTime timestamp = ZonedDateTime.now();
    private final String message;
}
