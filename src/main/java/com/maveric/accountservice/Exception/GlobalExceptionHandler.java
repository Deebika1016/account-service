package com.maveric.accountservice.Exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ConfigDataResourceNotFoundException.class)
public ResponseEntity<?> handleResourceNotFoundException(ConfigDataResourceNotFoundException exception, WebRequest request){
    ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
    return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalexception(Exception exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> Apiexception(ApiException exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> MethodNotAllowed(ApiException exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> BadRequest(ApiException exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

}
