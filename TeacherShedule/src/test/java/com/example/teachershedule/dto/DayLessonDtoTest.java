package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DayLessonDtoTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String subject = "Math";
        String subjectFull = "Mathematics";
        String startTime = "09:00";
        String endTime = "10:30";

        // Act
        DayLessonDto dayLessonDto = new DayLessonDto(subject, subjectFull, startTime, endTime);

        // Assert
        assertEquals(subject, dayLessonDto.getSubject());
        assertEquals(subjectFull, dayLessonDto.getSubjectFull());
        assertEquals(startTime, dayLessonDto.getStartTime());
        assertEquals(endTime, dayLessonDto.getEndTime());
    }

    @Test
    void testSetters() {
        // Arrange
        DayLessonDto dayLessonDto = new DayLessonDto("", "", "", "");

        // Act
        String subject = "Biology";
        String subjectFull = "Biology - Advanced";
        String startTime = "13:00";
        String endTime = "15:30";

        dayLessonDto.setSubject(subject);
        dayLessonDto.setSubjectFull(subjectFull);
        dayLessonDto.setStartTime(startTime);
        dayLessonDto.setEndTime(endTime);

        // Assert
        assertEquals(subject, dayLessonDto.getSubject());
        assertEquals(subjectFull, dayLessonDto.getSubjectFull());
        assertEquals(startTime, dayLessonDto.getStartTime());
        assertEquals(endTime, dayLessonDto.getEndTime());
    }
}
