package com.lopessystem.pocimproveapi.exceptions.handler;

import com.lopessystem.pocimproveapi.exceptions.EntityBeingUsedException;
import com.lopessystem.pocimproveapi.exceptions.EntityNotFoundException;
import com.lopessystem.pocimproveapi.exceptions.ExceptionMessage;
import com.lopessystem.pocimproveapi.exceptions.ExceptionType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Api exception handler.
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle entity not found response entity.
     *
     * @param ex         the ex
     * @param webRequest the web request
     * @return the response entity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest webRequest) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionType exceptionType = ExceptionType.RESOURCE_NOT_FOUND;
        String detail = ex.getMessage();

        ExceptionMessage exceptionMessage = createExceptionMessageBuilder(status, exceptionType, detail, webRequest);

        return handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), status, webRequest);
    }

    /**
     * Handle entity being used exception response entity.
     *
     * @param ex         the ex
     * @param webRequest the web request
     * @return the response entity
     */
    @ExceptionHandler(EntityBeingUsedException.class)
    public ResponseEntity<Object> handleEntityBeingUsedException(EntityBeingUsedException ex, WebRequest webRequest) {

        HttpStatus status = HttpStatus.CONFLICT;
        ExceptionType exceptionType = ExceptionType.ENTITY_BEING_USED;
        String detail = ex.getMessage();

        ExceptionMessage exceptionMessage = createExceptionMessageBuilder(status, exceptionType, detail, webRequest);

        return handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), status, webRequest);
    }

    /**
     * Create exception message builder exception message.
     *
     * @param status        the status
     * @param exceptionType the exception type
     * @param detail        the detail
     * @param webRequest    the web request
     * @return the exception message
     */
    private ExceptionMessage createExceptionMessageBuilder(HttpStatus status, ExceptionType exceptionType, String detail,
                                                           WebRequest webRequest) {

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();

        return new ExceptionMessage(status.value(), exceptionType.getUri(), exceptionType.getTitle(), detail,
                request.getRequestURL().toString());

    }

}
