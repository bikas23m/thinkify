package com.bikas23m.thinkify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());

    }

    @ExceptionHandler({DriverNotFoundUnder5UnitDistanceException.class})
    public ResponseEntity<Object> handleDriverNotFoundUnder5UnitDistanceException(DriverNotFoundUnder5UnitDistanceException exception){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());

    }

    @ExceptionHandler({DriverIsNotAvailableException.class})
    public ResponseEntity<Object> handleDriverIsNotAvailableException(DriverIsNotAvailableException exception){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());

    }

}
