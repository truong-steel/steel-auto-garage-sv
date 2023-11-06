package com.vti.steel.exception;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatusCode;

import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import java.util.HashMap;



@ControllerAdvice

public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override

    protected ResponseEntity<Object> handleMethodArgumentNotValid(

            MethodArgumentNotValidException exception,

            HttpHeaders headers, HttpStatusCode status, WebRequest request

    ) {

        var message = "Sorry! Invalid data.";

        var errors = new HashMap<String, String>();

        for (FieldError error : exception.getFieldErrors()) {

            var key = error.getField();

            var value = error.getDefaultMessage();

            errors.put(key, value);

        }

        var response = new ErrorResponse(message, errors);

        return new ResponseEntity<>(response, headers, status);

    }



    @ExceptionHandler(ConstraintViolationException.class)

    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException exception) {

        var message = "Sorry! Invalid data.";

        var errors = new HashMap<String, String>();

        for (var error : exception.getConstraintViolations()) {

            var key = error.getPropertyPath().toString();

            var value = error.getMessage();

            errors.put(key, value);

        }

        var response = new ErrorResponse(message, errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}