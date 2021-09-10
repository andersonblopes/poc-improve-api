package com.lopessystem.pocimproveapi.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Long entityId) {
        super(String.format(message, entityId));
    }
}
