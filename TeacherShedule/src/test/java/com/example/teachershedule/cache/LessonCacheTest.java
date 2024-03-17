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
        // Arrange
        int key = 1;
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(1);

        // Act
        lessonCache.saveLessonResponse(key, lessonDto);
        lessonCache.removeLessonResponse(key);
        LessonDto retrievedLessonDto = lessonCache.getLessonResponse(key);

        // Assert
        assertNull(retrievedLessonDto);
    }

    @Test
    void testClearLessonResponses() {
        // Arrange
        lessonCache.saveLessonResponse(1, new LessonDto());
        lessonCache.saveLessonResponse(2, new LessonDto());

        // Act
        lessonCache.clearLessonResponses();

        // Assert
        assertEquals(0, lessonCache.getSizeOfLessonResponses());
    }

    @Test
    void testGetSizeOfLessonResponses() {
        // Arrange
        lessonCache.saveLessonResponse(1, new LessonDto());
        lessonCache.saveLessonResponse(2, new LessonDto());

        // Act
        int size = lessonCache.getSizeOfLessonResponses();

        // Assert
        assertEquals(2, size);
    }
}

