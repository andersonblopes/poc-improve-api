package com.lopessystem.pocimproveapi.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * The type Exception message.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@JsonPropertyOrder({"status", "uiMessage", "usedResource", "type", "title", "detail", "timestamp"})
public class ExceptionMessage {

    /**
     * The Fields.
     */
    List<Field> fields;
    /**
     * The Status.
     */
    private Integer status;
    /**
     * The Type.
     */
    private String type;
    /**
     * The Title.
     */
    private String title;
    /**
     * The Detail.
     */
    private String detail;
    /**
     * The Timestamp.
     */
    private OffsetDateTime timestamp;
    /**
     * The Used resource.
     */
    private String usedResource;
    /**
     * The Ui message.
     */
    private String uiMessage;


    /**
     * Instantiates a new Exception message.
     *
     * @param title     the title
     * @param status    the status
     * @param uiMessage the ui message
     */
    public ExceptionMessage(String title, int status, String uiMessage) {
        timestamp = OffsetDateTime.now();
        this.title = title;
        this.status = status;
        this.uiMessage = uiMessage;

    }

    /**
     * Instantiates a new Exception message.
     *
     * @param status       the status
     * @param type         the type
     * @param title        the title
     * @param detail       the detail
     * @param usedResource the used resource
     */
    public ExceptionMessage(Integer status, String type, String title, String detail, String usedResource) {
        this.status = status;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.usedResource = usedResource;
        timestamp = OffsetDateTime.now();
    }

}

