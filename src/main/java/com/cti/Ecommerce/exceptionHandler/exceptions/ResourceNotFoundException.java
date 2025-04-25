package com.cti.Ecommerce.exceptionHandler.exceptions;

import lombok.Getter;

import static com.cti.Ecommerce.request_setting.RequestResultConstant.MESSAGE_RESOURCE_NOT_FOUND;
import static com.cti.Ecommerce.request_setting.RequestResultConstant.RESULT_CODE_RESOURCE_NOT_FOUND;
@Getter
public class ResourceNotFoundException extends ApiException  {
    private final String resourceName;
    private final String fieldName;
    private final String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(RESULT_CODE_RESOURCE_NOT_FOUND, MESSAGE_RESOURCE_NOT_FOUND + " " + resourceName + " (" + fieldName + " : " + fieldValue + ")");
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
