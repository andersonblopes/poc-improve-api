package com.lopessystem.pocimproveapi.exceptions;

import lombok.Builder;
import lombok.Getter;

/**
 * The type Field.
 */
@Getter
@Builder
public class Field {

    /**
     * The Name.
     */
    private final String name;

    /**
     * The Message.
     */
    private final String message;

}

