package com.example.teachershedule.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeacherEntityTest {

    @Test
    void testTeacherEntityGettersAndSetters() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1);
        teacherEntity.setFirstName("John");
        teacherEntity.setMiddleName("Doe");
        teacherEntity.setLastName("Smith");
        teacherEntity.setEmail("john.smith@example.com");

        assertEquals(1, teacherEntity.getId());
        assertEquals("John", teacherEntity.getFirstName());
        assertEquals("Doe", teacherEntity.getMiddleName());
        assertEquals("Smith", teacherEntity.getLastName());
        assertEquals("john.smith@example.com", teacherEntity.getEmail());
    }

    @Test
    void testTeacherEntityLessonsAssociation() {
        TeacherEntity teacherEntity = new TeacherEntity();
        LessonEntity lessonEntity1 = new LessonEntity();
        LessonEntity lessonEntity2 = new LessonEntity();

        List<LessonEntity> lessons = new ArrayList<>();
        lessons.add(lessonEntity1);
        lessons.add(lessonEntity2);

        teacherEntity.setLessons(lessons);

        assertEquals(2, teacherEntity.getLessons().size());
        assertTrue(teacherEntity.getLessons().contains(lessonEntity1));
        assertTrue(teacherEntity.getLessons().contains(lessonEntity2));
    }
}
