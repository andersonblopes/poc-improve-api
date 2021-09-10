package com.lopessystem.pocimproveapi.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@JsonPropertyOrder({"status", "uiMessage", "usedResource", "type", "title", "detail", "timestamp"})
public class ExceptionMessage {

    List<Field> fields;
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private OffsetDateTime timestamp;
    private String usedResource;
    private String uiMessage;


    public ExceptionMessage(String title, int status, String uiMessage) {
        timestamp = OffsetDateTime.now();
        this.title = title;
        this.status = status;
        this.uiMessage = uiMessage;

    }

    public ExceptionMessage(Integer status, String type, String title, String detail, String usedResource) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.usedResource = usedResource;
        timestamp = OffsetDateTime.now();
    }

}

