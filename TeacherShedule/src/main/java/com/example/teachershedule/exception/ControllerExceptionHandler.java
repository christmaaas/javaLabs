package com.example.teachershedule.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<String> handleIllegalArgumentException(HttpClientErrorException ex, WebRequest request) {
        logger.error("ERROR 400: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR 400: Bad request");
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleAllExceptions(RuntimeException ex, WebRequest request) {
        logger.error("ERROR 500: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR 500: Internal server error");
    }
}
