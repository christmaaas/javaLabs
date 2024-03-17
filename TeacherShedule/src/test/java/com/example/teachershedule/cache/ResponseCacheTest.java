package com.example.teachershedule.cache;

import com.example.teachershedule.dto.ScheduleResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ResponseCacheTest {

    private ResponseCache responseCache;

    @BeforeEach
    void setUp() {
        responseCache = new ResponseCache();
    }

    @Test
    void testSaveAndGetScheduleResponse() {
        // Arrange
        String key = "1";
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        scheduleResponseDto.setStartDate("2024-03-17");

        // Act
        responseCache.saveScheduleResponse(key, scheduleResponseDto);
        ScheduleResponseDto retrievedScheduleResponseDto = responseCache.getScheduleResponse(key);

        // Assert
        assertEquals(scheduleResponseDto, retrievedScheduleResponseDto);
    }

    @Test
    void testRemoveScheduleResponse() {
        // Arrange
        String key = "1";
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        scheduleResponseDto.setStartDate("2024-03-17");

        // Act
        responseCache.saveScheduleResponse(key, scheduleResponseDto);
        responseCache.removeScheduleResponse(key);
        ScheduleResponseDto retrievedScheduleResponseDto = responseCache.getScheduleResponse(key);

        // Assert
        assertNull(retrievedScheduleResponseDto);
    }

    @Test
    void testClearScheduleResponses() {
        // Arrange
        responseCache.saveScheduleResponse("1", new ScheduleResponseDto());
        responseCache.saveScheduleResponse("2", new ScheduleResponseDto());

        // Act
        responseCache.clearScheduleResponses();

        // Assert
        assertEquals(0, responseCache.getSizeOfScheduleResponses());
    }

    @Test
    void testGetSizeOfScheduleResponses() {
        // Arrange
        responseCache.saveScheduleResponse("1", new ScheduleResponseDto());
        responseCache.saveScheduleResponse("2", new ScheduleResponseDto());

        // Act
        int size = responseCache.getSizeOfScheduleResponses();

        // Assert
        assertEquals(2, size);
    }
}


