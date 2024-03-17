package com.example.teachershedule.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class ControllerExceptionHandlerTest {

    /*@Test
    void testHandleNoResourceFoundException() {
        NoHandlerFoundException ex = mock(NoHandlerFoundException.class);
        WebRequest request = mock(WebRequest.class);

        ControllerExceptionHandler handler = new ControllerExceptionHandler();

        ResponseEntity<Object> responseEntity = handler.handleNoResourceFoundException(ex, request);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("404 Not Found", responseEntity.getBody());
    }

    @Test
    void testHandleRuntimeException() {
        ControllerExceptionHandler handler = new ControllerExceptionHandler();
        RuntimeException ex = new RuntimeException("Internal Server Error");

        ResponseEntity<Object> response = handler.handleAllExceptions(ex, null);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Internal Server Error"));
    }

    @Test
    void testHandleHttpClientErrorException() {
        ControllerExceptionHandler handler = new ControllerExceptionHandler();
        HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Bad Request");

        ResponseEntity<Object> response = handler.handleIllegalArgumentException(ex, null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Bad Request"));
    }

    @Test
    void testHandleMethodNotSupportedException() {
        ControllerExceptionHandler handler = new ControllerExceptionHandler();
        HttpRequestMethodNotSupportedException ex = new HttpRequestMethodNotSupportedException("Method Not Allowed");

        ResponseEntity<Object> response = handler.handleMethodNotSupportedException(ex, null);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Method Not Allowed"));
    }*/
}
