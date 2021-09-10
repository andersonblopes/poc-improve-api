package com.lopessystem.pocimproveapi.exceptions;

/**
 * The type Entity not found exception.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param message the message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Entity not found exception.
     *
     * @param message  the message
     * @param entityId the entity id
     */
    public EntityNotFoundException(String message, Long entityId) {
        super(String.format(message, entityId));
    }
}
