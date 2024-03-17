package com.example.teachershedule.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LessonEntityTest {

    @Test
    public void testLessonEntityGettersAndSetters() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(1);
        lessonEntity.setSubject("Math");
        lessonEntity.setSubjectFull("Mathematics");
        lessonEntity.setDay("Monday");
        lessonEntity.setStartTime("09:00");
        lessonEntity.setEndTime("10:30");

        // Act & Assert
        assertEquals(1, lessonEntity.getId());
        assertEquals("Math", lessonEntity.getSubject());
        assertEquals("Mathematics", lessonEntity.getSubjectFull());
        assertEquals("Monday", lessonEntity.getDay());
        assertEquals("09:00", lessonEntity.getStartTime());
        assertEquals("10:30", lessonEntity.getEndTime());
    }

    @Test
    public void testLessonEntityTeacherAssociation() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1);
        teacherEntity.setFirstName("John");
        lessonEntity.setTeacher(teacherEntity);

        // Act & Assert
        assertEquals(teacherEntity, lessonEntity.getTeacher());
    }
}
