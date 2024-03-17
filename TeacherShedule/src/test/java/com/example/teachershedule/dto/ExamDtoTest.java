package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExamDtoTest {

    @Test
    void testSettersAndGetters() {
        // Arrange
        ExamDto examDto = new ExamDto();
        List<String> auditories = new ArrayList<>(Arrays.asList("Auditorium 101", "Auditorium 102"));
        String endLessonTime = "12:30";
        String lessonTypeAbbrev = "E";
        String note = "Final exam";
        int numSubgroup = 1;
        String startLessonTime = "10:00";
        List<StudentGroupDto> studentGroups = new ArrayList<>();
        studentGroups.add(new StudentGroupDto());
        String subject = "Math";
        String subjectFullName = "Mathematics";
        List<Integer> weekNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        String dateLesson = "2024-04-01";
        String startLessonDate = "2024-03-31";
        String endLessonDate = "2024-04-01";
        boolean announcement = true;
        boolean split = false;

        // Act
        examDto.setAuditories(auditories);
        examDto.setEndLessonTime(endLessonTime);
        examDto.setLessonTypeAbbrev(lessonTypeAbbrev);
        examDto.setNote(note);
        examDto.setNumSubgroup(numSubgroup);
        examDto.setStartLessonTime(startLessonTime);
        examDto.setStudentGroups(studentGroups);
        examDto.setSubject(subject);
        examDto.setSubjectFullName(subjectFullName);
        examDto.setWeekNumber(weekNumber);
        examDto.setDateLesson(dateLesson);
        examDto.setStartLessonDate(startLessonDate);
        examDto.setEndLessonDate(endLessonDate);
        examDto.setAnnouncement(announcement);
        examDto.setSplit(split);

        // Assert
        assertEquals(auditories, examDto.getAuditories());
        assertEquals(endLessonTime, examDto.getEndLessonTime());
        assertEquals(lessonTypeAbbrev, examDto.getLessonTypeAbbrev());
        assertEquals(note, examDto.getNote());
        assertEquals(numSubgroup, examDto.getNumSubgroup());
        assertEquals(startLessonTime, examDto.getStartLessonTime());
        assertEquals(studentGroups, examDto.getStudentGroups());
        assertEquals(subject, examDto.getSubject());
        assertEquals(subjectFullName, examDto.getSubjectFullName());
        assertEquals(weekNumber, examDto.getWeekNumber());
        assertEquals(dateLesson, examDto.getDateLesson());
        assertEquals(startLessonDate, examDto.getStartLessonDate());
        assertEquals(endLessonDate, examDto.getEndLessonDate());
        assertEquals(announcement, examDto.isAnnouncement());
        assertEquals(split, examDto.isSplit());
    }
}
