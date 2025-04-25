package com.cti.Ecommerce.exceptionHandler;

import com.cti.Ecommerce.exceptionHandler.exceptions.ApiException;
import com.cti.Ecommerce.exceptionHandler.exceptions.RequestBadParameterException;
import com.cti.Ecommerce.exceptionHandler.exceptions.ResourceNotFoundException;
import com.cti.Ecommerce.request_setting.RequestResult;
import jakarta.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;

import static com.cti.Ecommerce.request_setting.RequestResultConstant.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException apiException, WebRequest webRequest) {
        var errorDetails = RequestResult.error(
                apiException.getCode(),
                apiException.getMessage(),
                null,
                (apiException.getDetails() != null) ? (String) apiException.getDetails() : webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception, WebRequest webRequest) {
        var errorDetails = RequestResult.error(
                RESULT_CODE_UNKNOWN_EXCEPTION,
                exception.getMessage(),
                null,
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RequestResult<HashMap<String, String>>> handleWrongArgumentException(MethodArgumentNotValidException exception) {
        HashMap<String, String> errors = new HashMap<>();
        exception.getAllErrors().forEach((error) -> {
            FieldError fieldError = (FieldError) error;
            // errors.put(fieldError.getField(), fieldError.getDefaultMessage() != null ? fieldError.getDefaultMessage() : "");
        });
        RequestResult<HashMap<String, String>> requestResultK = RequestResult
                .error(RESULT_BAD_REQUEST_PARAMETER,
                        MESSAGE_BAD_REQUEST_PARAMETER,
                        errors
                );
        return new ResponseEntity<>(requestResultK, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RequestBadParameterException.class)
    public ResponseEntity<RequestResult<HashMap<String, String>>> handleRequestBadParameterException(RequestBadParameterException exception) {
        HashMap<String, String> errors = new HashMap<>();
        String message = exception.getFieldsValues().get(0) + ". " + exception.getFieldsErrorMessage().get(0);
/*        exception.getFieldsInvolve().forEachIndexed((index, field) -> {
            errors.put(field, exception.getFieldsValues().get(index) + ". " + exception.getFieldsErrorMessage().get(index));
        });*/
        RequestResult<HashMap<String, String>> requestResult = RequestResult.error(RESULT_BAD_REQUEST_PARAMETER, message, errors);
        return new ResponseEntity<>(requestResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RequestResult<HashMap<String, String>>> handleException(ResourceNotFoundException exception) {
        String message = "The resource "
                + exception.getResourceName()
                + " specified in field "
                + exception.getFieldName()
                + " with value "
                + exception.getFieldValue()
                + " is not found";
        RequestResult<HashMap<String, String>> requestResult = RequestResult.error(
                RESULT_CODE_RESOURCE_NOT_FOUND,
                message,
                null
        );
        return new ResponseEntity<>(requestResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<RequestResult<HashMap<String, String>>> handleException(MessagingException exp){
        RequestResult<HashMap<String, String>> requestResult = RequestResult.error(
                RESULT_CODE_RESOURCE_NOT_FOUND,
                "Internal error occurred during the messaging operation. Contact the admin" + exp.getMessage(),
                null
        );
        return new ResponseEntity<>(requestResult, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//
//    @ExceptionHandler(InitialisationAlreadyDoneException.class)
//    public ResponseEntity<RequestResult<HashMap<String, String>>> handleException(InitialisationAlreadyDoneException exception) {
//        RequestResult<HashMap<String, String>> requestResultK = RequestResult.error(RESULT_CODE_SYSTEM_ALREADY_INIT, MESSAGE_SYSTEM_ALREADY_INIT, null);
//        return ResponseEntity(requestResultK,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(SystemInitialisationFailedException.class)
//    public ResponseEntity<RequestResult<HashMap<String, String>>> handleException(SystemInitialisationFailedException exception) {
//        RequestResultK<HashMap<String, String>> requestResultK = RequestResult.error(RESULT_CODE_SYSTEM_INITIALISATION_FAILED, MESSAGE_SYSTEM_INITIALISATION_FAILED, null);
//        return ResponseEntity(requestResultK,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(SystemNotInitialiseException.class)
//    public ResponseEntity<RequestResult<HashMap<String, String>>> handleException(SystemNotInitialiseException exception) {
//        RequestResult<HashMap<String, String>> requestResultK = RequestResult.error(RESULT_CODE_SYSTEM_NOT_INITIALISE_EXCEPTION, MESSAGE_SYSTEM_NOT_INITIALISE, null);
//        return ResponseEntity(requestResultK,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(InvalidCredentialsException.class)
//    public ResponseEntity<RequestResult<HashMap<String, String>>> handleException(InvalidCredentialsException exception) {
//        RequestResult<HashMap<String, String>> requestResultK = RequestResult.error(RESULT_CODE_BAD_CREDENTIALS, MESSAGE_BAD_CREDENTIALS, null);
//        return ResponseEntity(requestResultK,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
