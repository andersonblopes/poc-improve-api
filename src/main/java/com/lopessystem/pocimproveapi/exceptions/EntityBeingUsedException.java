package com.lopessystem.pocimproveapi.exceptions;

/**
 * The type Entity being used exception.
 */
public class EntityBeingUsedException extends RuntimeException {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Entity being used exception.
     *
     * @param message the message
     */
    public EntityBeingUsedException(String message) {
        super(message);
    }
}
