package com.example.teachershedule.cache;

import com.example.teachershedule.dto.LessonDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LessonCacheTest {

    private LessonCache lessonCache;

    @BeforeEach
    void setUp() {
        lessonCache = new LessonCache();
    }

    @Test
    void testSaveAndGetLessonResponse() {
        // Arrange
        int key = 1;
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(1);

        // Act
        lessonCache.saveLessonResponse(key, lessonDto);
        LessonDto retrievedLessonDto = lessonCache.getLessonResponse(key);

        // Assert
        assertEquals(lessonDto, retrievedLessonDto);
    }

    @Test
    void testRemoveLessonResponse() {
        int key = 1;
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(1);

        lessonCache.saveLessonResponse(key, lessonDto);
        lessonCache.removeLessonResponse(key);
        LessonDto retrievedLessonDto = lessonCache.getLessonResponse(key);

        assertNull(retrievedLessonDto);
    }

    @Test
    void testClearLessonResponses() {
        lessonCache.saveLessonResponse(1, new LessonDto());
        lessonCache.saveLessonResponse(2, new LessonDto());

        lessonCache.clearLessonResponses();

        assertEquals(0, lessonCache.getSizeOfLessonResponses());
    }

    @Test
    void testGetSizeOfLessonResponses() {
        lessonCache.saveLessonResponse(1, new LessonDto());
        lessonCache.saveLessonResponse(2, new LessonDto());

        int size = lessonCache.getSizeOfLessonResponses();

        assertEquals(2, size);
    }
}

