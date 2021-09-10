package com.lopessystem.pocimproveapi.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMerger {

    private ObjectMerger() {

    }

    public static void mergeRequestBodyToGenericObject(Map<String, Object> objectMap, Object objectToUpdate, Class type, HttpServletRequest servletRequest) {

        ServletServerHttpRequest servletServerHttpRequest = new ServletServerHttpRequest(servletRequest);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

            Object newObject = objectMapper.convertValue(objectMap, type);

            for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
                String fieldProp = entry.getKey();
                Field field = ReflectionUtils.findField(type, fieldProp);
                field.setAccessible(true);

                Object newValue = ReflectionUtils.getField(field, newObject);

                ReflectionUtils.setField(field, objectToUpdate, newValue);
            }

        } catch (IllegalArgumentException e) {
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            throw new HttpMessageNotReadableException(e.getMessage(), rootCause, servletServerHttpRequest);
        }
    }
}

