package com.javaguides.Restful_webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handlerResponseNotFound(ResourceNotFoundException exception, WebRequest webRequest ){
        ErrorDetail errorDetails = new ErrorDetail(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_not_found"

        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorDetail> handlerEmailAlreadyExist(EmailException exception, WebRequest webRequest ){
        ErrorDetail errorDetails = new ErrorDetail(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "EMAIL_ALREADY_EXIST"

        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handlerGlobalException(Exception exception, WebRequest webRequest ){
        ErrorDetail errorDetails = new ErrorDetail(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL_SERVER_ERROR"

        );

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
