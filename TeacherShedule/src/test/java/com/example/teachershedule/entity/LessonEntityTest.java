package com.example.teachershedule.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LessonEntityTest {

    @Test
    void testLessonEntityGettersAndSetters() {
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(1);
        lessonEntity.setSubject("Math");
        lessonEntity.setSubjectFull("Mathematics");
        lessonEntity.setDay("Monday");
        lessonEntity.setStartTime("09:00");
        lessonEntity.setEndTime("10:30");

        assertEquals(1, lessonEntity.getId());
        assertEquals("Math", lessonEntity.getSubject());
        assertEquals("Mathematics", lessonEntity.getSubjectFull());
        assertEquals("Monday", lessonEntity.getDay());
        assertEquals("09:00", lessonEntity.getStartTime());
        assertEquals("10:30", lessonEntity.getEndTime());
    }

    @Test
    void testLessonEntityTeacherAssociation() {
        LessonEntity lessonEntity = new LessonEntity();
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1);
        teacherEntity.setFirstName("John");
        lessonEntity.setTeacher(teacherEntity);

        assertEquals(teacherEntity, lessonEntity.getTeacher());
    }
}
