package com.example.teachershedule.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {

    @InjectMocks
    private ControllerExceptionHandler controllerExceptionHandler;

    @Test
    void testHandleIllegalArgumentException() {
        // Arrange
        HttpClientErrorException ex = mock(HttpClientErrorException.class);
        WebRequest request = mock(WebRequest.class);

        // Act
        ResponseEntity<Object> response = controllerExceptionHandler.handleIllegalArgumentException(ex, request);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ERROR 400: Bad request", response.getBody());
    }

    @Test
    void testHandleNoResourceFoundException() {
        // Arrange
        NoHandlerFoundException ex = mock(NoHandlerFoundException.class);
        WebRequest request = mock(WebRequest.class);

        // Act
        ResponseEntity<Object> response = controllerExceptionHandler.handleNoResourceFoundException(ex, request);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("ERROR 404: Not Found", response.getBody());
    }

    @Test
    void testHandleMethodNotSupportedException() {
        // Arrange
        HttpRequestMethodNotSupportedException ex = mock(HttpRequestMethodNotSupportedException.class);
        WebRequest request = mock(WebRequest.class);

        // Act
        ResponseEntity<Object> response = controllerExceptionHandler.handleMethodNotSupportedException(ex, request);

        // Assert
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());
        assertEquals("ERROR 405: Method not supported", response.getBody());
    }

    @Test
    void testHandleAllExceptions() {
        // Arrange
        RuntimeException ex = mock(RuntimeException.class);
        WebRequest request = mock(WebRequest.class);

        // Act
        ResponseEntity<Object> response = controllerExceptionHandler.handleAllExceptions(ex, request);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("ERROR 500: Internal server error", response.getBody());
    }
}

