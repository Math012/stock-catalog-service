package com.math012.catalog_service.infra.exception.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StructException> handlerResourceNotFoundException(Exception e, WebRequest request){
        StructException structException = new StructException(e.getMessage(),new Date(),request.getDescription(false));
        return new ResponseEntity<>(structException, HttpStatus.NOT_FOUND);
    }
}