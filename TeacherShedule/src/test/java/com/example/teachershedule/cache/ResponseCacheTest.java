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
        String key = "1";
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        scheduleResponseDto.setStartDate("2024-03-17");

        responseCache.saveScheduleResponse(key, scheduleResponseDto);
        ScheduleResponseDto retrievedScheduleResponseDto = responseCache.getScheduleResponse(key);

        assertEquals(scheduleResponseDto, retrievedScheduleResponseDto);
    }

    @Test
    void testRemoveScheduleResponse() {
        String key = "1";
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        scheduleResponseDto.setStartDate("2024-03-17");

        responseCache.saveScheduleResponse(key, scheduleResponseDto);
        responseCache.removeScheduleResponse(key);
        ScheduleResponseDto retrievedScheduleResponseDto = responseCache.getScheduleResponse(key);

        assertNull(retrievedScheduleResponseDto);
    }

    @Test
    void testClearScheduleResponses() {
        responseCache.saveScheduleResponse("1", new ScheduleResponseDto());
        responseCache.saveScheduleResponse("2", new ScheduleResponseDto());

        responseCache.clearScheduleResponses();

        assertEquals(0, responseCache.getSizeOfScheduleResponses());
    }

    @Test
    void testGetSizeOfScheduleResponses() {
        responseCache.saveScheduleResponse("1", new ScheduleResponseDto());
        responseCache.saveScheduleResponse("2", new ScheduleResponseDto());

        int size = responseCache.getSizeOfScheduleResponses();

        assertEquals(2, size);
    }
}


