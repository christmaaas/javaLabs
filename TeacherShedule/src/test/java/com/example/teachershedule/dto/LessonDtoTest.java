package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LessonDtoTest {

    @Test
    void testSettersAndGetters() {
        LessonDto lessonDto = new LessonDto();
        int id = 1;
        String subject = "Math";
        String subjectFull = "Mathematics";
        String day = "Monday";
        String startTime = "09:00";
        String endTime = "10:30";
        int teacherId = 101;

        lessonDto.setId(id);
        lessonDto.setSubject(subject);
        lessonDto.setSubjectFull(subjectFull);
        lessonDto.setDay(day);
        lessonDto.setStartTime(startTime);
        lessonDto.setEndTime(endTime);
        lessonDto.setTeacherId(teacherId);

        assertEquals(id, lessonDto.getId());
        assertEquals(subject, lessonDto.getSubject());
        assertEquals(subjectFull, lessonDto.getSubjectFull());
        assertEquals(day, lessonDto.getDay());
        assertEquals(startTime, lessonDto.getStartTime());
        assertEquals(endTime, lessonDto.getEndTime());
        assertEquals(teacherId, lessonDto.getTeacherId());
    }
}
