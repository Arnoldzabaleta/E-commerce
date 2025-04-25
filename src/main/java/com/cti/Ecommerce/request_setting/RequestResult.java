package com.cti.Ecommerce.request_setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.cti.Ecommerce.request_setting.RequestResultStatus.ERROR;
import static com.cti.Ecommerce.request_setting.RequestResultStatus.SUCCESS;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestResult<T>{
    private Date timestamp;
    private T data;
    private int code;
    private String status;
    private String message;
    private Object details;

    public static <T> RequestResult<T> error(int code, String message, T data) {
        return new RequestResult<>(new Date(), data, code, ERROR.getStatus(), message, null);
    }

    public static <T> RequestResult<T> error(int code, String message, T data, Object details) {
        return new RequestResult<>(new Date(), data, code, ERROR.getStatus(), message, details);
    }

    public static <T> RequestResult<T> success(T data, int code) {
        return new RequestResult<T>(new Date(), data, code, SUCCESS.getStatus(), "Request processed successfully", null);
    }

    public static <T> RequestResult<T> success(T data, int code, String message) {
        return new RequestResult<T>(new Date(), data, code, SUCCESS.getStatus(), message, null);
    }
}
