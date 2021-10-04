package com.lopessystem.pocimproveapi.resource.impl;

import com.lopessystem.pocimproveapi.resource.LoggingController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Logging controller.
 */
@RestController
@Slf4j
public class LoggingControllerImpl implements LoggingController {

    /**
     * Logs string.
     *
     * @return the string
     */
    @Override
    public String logs() {

        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Successfully! Check out the Logs on the logs directory to see the output...";
    }
}
