package br.com.educ4.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL
            = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o problema persistir, entre em contato com o administrador do sistema.";


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public HttpErrorInfo handleRuntimeExceptions(RuntimeException ex) {
        log.info("Message: {}", ex);
        return createHttpErrorInfo(ex.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    public HttpErrorInfo handleNoSuchElementException(RuntimeException ex) {
        log.info("Message: {}", ex);
        return createHttpErrorInfo(ex.getMessage());
    }

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpErrorInfo handleExceptions(Exception ex) {
        log.info("Message: {}", ex);
        return createHttpErrorInfo(MSG_ERRO_GENERICA_USUARIO_FINAL);
    }

    private HttpErrorInfo createHttpErrorInfo(String msg) {
        final String message = msg;

        return HttpErrorInfo.builder()
                .message(message)
                .build();
    }

}
