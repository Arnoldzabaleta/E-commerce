package com.cti.Ecommerce.exceptionHandler.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException extends RuntimeException {
    private int code;
    private Object details;

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ApiException(int code, String message, Object details) {
        super(message);
        this.code = code;
        this.details = details;
    }
}
