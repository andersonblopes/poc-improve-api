package com.lopessystem.pocimproveapi.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 * The type Serialize json resource test support.
 */
public class SerializeJsonResourceTestSupport {

    /**
     * Convert object to json bytes byte [ ].
     *
     * @param entity the entity
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    public static byte[] convertObjectToJsonBytes(Object entity) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new JavaTimeModule());

        return mapper.writeValueAsBytes(entity);
    }
}
