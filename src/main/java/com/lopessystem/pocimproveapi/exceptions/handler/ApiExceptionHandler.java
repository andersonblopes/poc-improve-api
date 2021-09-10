package com.lopessystem.pocimproveapi.exceptions.handler;

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

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest webRequest) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionType exceptionType = ExceptionType.RESOURCE_NOT_FOUND;
        String detail = ex.getMessage();

        ExceptionMessage exceptionMessage = createExceptionMessageBuilder(status, exceptionType, detail, webRequest);

        return handleExceptionInternal(ex, exceptionMessage, new HttpHeaders(), status, webRequest);
    }

    public ExceptionMessage createExceptionMessageBuilder(HttpStatus status, ExceptionType exceptionType, String detail,
                                                          WebRequest webRequest) {

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();

        return new ExceptionMessage(status.value(), exceptionType.getUri(), exceptionType.getTitle(), detail,
                request.getRequestURL().toString());

    }

}
