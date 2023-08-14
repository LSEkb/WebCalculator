package com.laserova.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception error) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Получена ошибка: " + error.getMessage());
    }
}
