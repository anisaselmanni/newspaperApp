package com.example.newspaperapp.controllers;

import com.example.newspaperapp.dtos.ErrorResponse;
import com.example.newspaperapp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {
    // Exception for validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        var errorResponse = new ErrorResponse("Validation Error", HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); // 400
    }

    // Exception for general errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), null), // 500
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    // Exception for resource not found errors
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value(), null), // 404
                HttpStatus.NOT_FOUND
        );
    }

    // Exception for illegal argument exception
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value(), null), // 409
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponse> handleIllegalStateException(IllegalStateException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value(), null), // 409
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException e) {
        return new ResponseEntity<>(
//                new ErrorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED.value(), null), // 401
                new ErrorResponse("Invalid username or password", HttpStatus.UNAUTHORIZED.value(), null), // 401
                HttpStatus.UNAUTHORIZED
        );
    }
}