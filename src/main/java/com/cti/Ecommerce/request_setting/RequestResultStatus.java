package com.cti.Ecommerce.request_setting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RequestResultStatus {
    SUCCESS("SUCCESS"),
    ERROR("ERROR"),
    NOT_ENOUGH_FOUND("NOT ENOUGH FOUND"),
    IN_PENDING_STATE("IN PENDING STATE"),
    TIMED_OUT_OR_EXPIRED("TIMED OUT OR EXPIRED");

    private final String status;
}
