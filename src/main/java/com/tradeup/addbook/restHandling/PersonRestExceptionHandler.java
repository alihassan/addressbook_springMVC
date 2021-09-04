package com.tradeup.addbook.restHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonRestExceptionHandler {

    //Exception handler for Person not found and Bad Request

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exc){

        PersonErrorResponse error = new PersonErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMsg(exc.getMessage());
        error.setTime(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PersonErrorResponse> handleException(Exception exc){
        PersonErrorResponse error = new PersonErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMsg("Bad Request Error. Please Check, According to status code");
        error.setTime(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
