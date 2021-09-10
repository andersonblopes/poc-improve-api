package com.lopessystem.pocimproveapi.exceptions;

import lombok.Getter;

/**
 * The enum Exception type.
 */
@Getter
public enum ExceptionType {

    // TODO Is necessary to create each html page to represent the path address.

    /**
     * The Resource not found.
     */
    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    /**
     * The Entity being used.
     */
    ENTITY_BEING_USED("/entity-being-used", "Entity Being Used"),
    /**
     * The Error business.
     */
    ERROR_BUSINESS("/error-business", "Business Role Violation"),
    /**
     * The Error not yet handled.
     */
    ERROR_NOT_YET_HANDLED("/error-not-yet-handled", "Error Not Yet Handled"),
    /**
     * The Message not recognize.
     */
    MESSAGE_NOT_RECOGNIZE("/message-not-recognize", "Message Not Recognize"),
    /**
     * The Message not readable.
     */
    MESSAGE_NOT_READABLE("/message-not-readable", "Message not Readable"),
    /**
     * The Method argument not valid.
     */
    METHOD_ARGUMENT_NOT_VALID("/method-argument-not-valid", "Method Argument Not Valid"),
    /**
     * The Invalid parameter.
     */
    INVALID_PARAMETER("/invalid-parameter", "Invalid Parameter"),
    /**
     * The System error.
     */
    SYSTEM_ERROR("/system-error", "System Error");

    /**
     * The Title.
     */
    private final String title;
    /**
     * The Uri.
     */
    private final String uri;

    /**
     * Instantiates a new Exception type.
     *
     * @param path  the path
     * @param title the title
     */
    ExceptionType(String path, String title) {
        uri = "https://lopessystem.com/api/errors" + path;
        this.title = title;
    }

}
