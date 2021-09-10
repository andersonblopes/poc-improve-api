package com.lopessystem.pocimproveapi.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionType {

    // TODO Is necessary to create each html page to represent the path address.

    RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
    ENTITY_BEING_USED("/entity-being-used", "Entity Being Used"),
    ERROR_BUSINESS("/error-business", "Business Role Violation"),
    ERROR_NOT_YET_HANDLED("/error-not-yet-handled", "Error Not Yet Handled"),
    MESSAGE_NOT_RECOGNIZE("/message-not-recognize", "Message Not Recognize"),
    MESSAGE_NOT_READABLE("/message-not-readable", "Message not Readable"),
    METHOD_ARGUMENT_NOT_VALID("/method-argument-not-valid", "Method Argument Not Valid"),
    INVALID_PARAMETER("/invalid-parameter", "Invalid Parameter"),
    SYSTEM_ERROR("/system-error", "System Error");

    private final String title;
    private final String uri;

    ExceptionType(String path, String title) {
        uri = "https://lopessystem.com/api/errors" + path;
        this.title = title;
    }

}
