package com.example.teachershedule.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<String> handleIllegalArgumentException(HttpClientErrorException ex,
                                                                 WebRequest request) {
        logger.error("ERROR 400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR 400: Bad request");
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<String> handleNoResourceFoundException(NoHandlerFoundException ex,
                                                                 WebRequest request) {
        logger.error("ERROR 404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR 404: Not Found");
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<String> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex,
                                                                    WebRequest request) {
        logger.error("ERROR 405");
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("ERROR 405: Method not supported");
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleAllExceptions(RuntimeException ex,
                                                      WebRequest request) {
        logger.error("ERROR 500");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR 500: Internal server error");
    }
}
