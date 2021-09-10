package com.lopessystem.pocimproveapi.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Field {

    private final String name;

    private final String message;

}

