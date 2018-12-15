package com.bellacode.homebudget.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RestExceptionResponse> handlerException(NotFoundException exc){
        RestExceptionResponse exceptionResponse = new RestExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RestExceptionResponse> handlerException(UserEmailExistException exc){
        RestExceptionResponse exceptionResponse = new RestExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                exc.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    /*
        Handle any exception
    */
    @ExceptionHandler
    public ResponseEntity<RestExceptionResponse> handlerException(Exception exc){
        RestExceptionResponse exceptionResponse = new RestExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }



}
