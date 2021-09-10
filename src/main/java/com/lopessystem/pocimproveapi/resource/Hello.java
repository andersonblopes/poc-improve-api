package com.lopessystem.pocimproveapi.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface Hello extends Versionable {

    @GetMapping("/hello")
    ResponseEntity<String> hello();
}
