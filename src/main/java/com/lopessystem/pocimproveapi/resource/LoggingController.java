package com.lopessystem.pocimproveapi.resource;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * The interface Logging controller.
 */
public interface LoggingController extends Versionable {

    /**
     * Logs string.
     *
     * @return the string
     */
    @GetMapping("/logs")
    String logs();
}
