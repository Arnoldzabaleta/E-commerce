package com.cti.Ecommerce.exceptionHandler.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.cti.Ecommerce.request_setting.RequestResultConstant.MESSAGE_BAD_REQUEST_PARAMETER;
import static com.cti.Ecommerce.request_setting.RequestResultConstant.RESULT_BAD_REQUEST_PARAMETER;

@Getter
@Setter
public class RequestBadParameterException extends ApiException  {
    private List<String> fieldsInvolved;
    private List<Object> fieldsValues;
    private List<String> fieldsErrorMessage;

    public RequestBadParameterException(List<String> fieldsInvolved, List<Object> fieldsValues, List<String> fieldsErrorMessage) {
        super(RESULT_BAD_REQUEST_PARAMETER, MESSAGE_BAD_REQUEST_PARAMETER);
        this.fieldsInvolved = fieldsInvolved;
        this.fieldsValues = fieldsValues;
        this.fieldsErrorMessage = fieldsErrorMessage;
    }
}
