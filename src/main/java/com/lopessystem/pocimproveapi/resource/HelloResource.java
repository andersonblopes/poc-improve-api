package com.lopessystem.pocimproveapi.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The interface Hello resource.
 */
public interface HelloResource extends Versionable {

    /**
     * Hello response entity.
     *
     * @return the response entity
     */
    @GetMapping("/hello")
    ResponseEntity<String> hello();
}
