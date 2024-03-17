package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DayLessonDtoTest {

    @Test
    void testConstructorAndGetters() {
        String subject = "Math";
        String subjectFull = "Mathematics";
        String startTime = "09:00";
        String endTime = "10:30";

        DayLessonDto dayLessonDto = new DayLessonDto(subject, subjectFull, startTime, endTime);

        assertEquals(subject, dayLessonDto.getSubject());
        assertEquals(subjectFull, dayLessonDto.getSubjectFull());
        assertEquals(startTime, dayLessonDto.getStartTime());
        assertEquals(endTime, dayLessonDto.getEndTime());
    }

    @Test
    void testSetters() {
        DayLessonDto dayLessonDto = new DayLessonDto("", "", "", "");

        String subject = "Biology";
        String subjectFull = "Biology - Advanced";
        String startTime = "13:00";
        String endTime = "15:30";

        dayLessonDto.setSubject(subject);
        dayLessonDto.setSubjectFull(subjectFull);
        dayLessonDto.setStartTime(startTime);
        dayLessonDto.setEndTime(endTime);

        assertEquals(subject, dayLessonDto.getSubject());
        assertEquals(subjectFull, dayLessonDto.getSubjectFull());
        assertEquals(startTime, dayLessonDto.getStartTime());
        assertEquals(endTime, dayLessonDto.getEndTime());
    }
}
