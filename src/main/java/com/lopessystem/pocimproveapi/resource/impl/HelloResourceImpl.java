package com.lopessystem.pocimproveapi.resource.impl;

import com.lopessystem.pocimproveapi.resource.HelloResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Hello resource.
 */
@Slf4j
@RestController
@AllArgsConstructor
public class HelloResourceImpl implements HelloResource {

    /**
     * Hello response entity.
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world!");
    }
}
