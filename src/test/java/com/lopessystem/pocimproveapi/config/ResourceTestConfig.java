package com.lopessystem.pocimproveapi.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * The type Resource test config.
 */
@ExtendWith(SpringExtension.class)
public abstract class ResourceTestConfig {

    /**
     * The Mock mvc.
     */
    @Autowired
    protected MockMvc mockMvc;

}
