package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class ScheduleDtoTest {

    @Test
    void testSettersAndGetters() {
        // Arrange
        ScheduleDto scheduleDto = new ScheduleDto();
        List<String> auditories = new ArrayList<>();
        auditories.add("Auditory 1");
        auditories.add("Auditory 2");
        String endLessonTime = "12:00";
        String lessonTypeAbbrev = "Lecture";
        String note = "Note";
        int numSubgroup = 1;
        String startLessonTime = "10:00";
        List<StudentGroupDto> studentGroups = new ArrayList<>();
        StudentGroupDto studentGroupDto = new StudentGroupDto();
        studentGroupDto.setSpecialityName("Computer Science");
        studentGroups.add(studentGroupDto);
        String subject = "Mathematics";
        String subjectFullName = "Mathematics for Computer Science";
        List<Integer> weekNumber = new ArrayList<>();
        weekNumber.add(1);
        weekNumber.add(2);
        String dateLesson = "2024-03-17";
        String startLessonDate = "2024-03-17";
        String endLessonDate = "2024-03-17";
        boolean announcement = true;
        boolean split = false;

        // Act
        scheduleDto.setAuditories(auditories);
        scheduleDto.setEndLessonTime(endLessonTime);
        scheduleDto.setLessonTypeAbbrev(lessonTypeAbbrev);
        scheduleDto.setNote(note);
        scheduleDto.setNumSubgroup(numSubgroup);
        scheduleDto.setStartLessonTime(startLessonTime);
        scheduleDto.setStudentGroups(studentGroups);
        scheduleDto.setSubject(subject);
        scheduleDto.setSubjectFullName(subjectFullName);
        scheduleDto.setWeekNumber(weekNumber);
        scheduleDto.setDateLesson(dateLesson);
        scheduleDto.setStartLessonDate(startLessonDate);
        scheduleDto.setEndLessonDate(endLessonDate);
        scheduleDto.setAnnouncement(announcement);
        scheduleDto.setSplit(split);

        // Assert
        assertEquals(auditories, scheduleDto.getAuditories());
        assertEquals(endLessonTime, scheduleDto.getEndLessonTime());
        assertEquals(lessonTypeAbbrev, scheduleDto.getLessonTypeAbbrev());
        assertEquals(note, scheduleDto.getNote());
        assertEquals(numSubgroup, scheduleDto.getNumSubgroup());
        assertEquals(startLessonTime, scheduleDto.getStartLessonTime());
        assertEquals(studentGroups, scheduleDto.getStudentGroups());
        assertEquals(subject, scheduleDto.getSubject());
        assertEquals(subjectFullName, scheduleDto.getSubjectFullName());
        assertEquals(weekNumber, scheduleDto.getWeekNumber());
        assertEquals(dateLesson, scheduleDto.getDateLesson());
        assertEquals(startLessonDate, scheduleDto.getStartLessonDate());
        assertEquals(endLessonDate, scheduleDto.getEndLessonDate());
        assertEquals(announcement, scheduleDto.isAnnouncement());
        assertEquals(split, scheduleDto.isSplit());
    }
}
