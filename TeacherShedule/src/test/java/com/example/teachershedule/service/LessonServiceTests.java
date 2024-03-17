package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.service.LessonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LessonServiceTests {

    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private TeacherScheduleRepository teacherRepository;

    @InjectMocks
    private LessonService lessonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addLesson_Success() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setSubject("Math");

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName("Smith");

        when(teacherRepository.findByLastName("Smith"))
                .thenReturn(teacherEntity);

        when(lessonRepository.save(any(LessonEntity.class)))
                .thenReturn(lessonEntity);

        // Act
        LessonEntity result = lessonService.addLesson(lessonEntity, "Smith");

        // Assert
        assertNotNull(result);
        assertEquals("Math", result.getSubject());
        assertEquals(teacherEntity, result.getTeacher());
        verify(lessonRepository, times(1)).save(lessonEntity);
    }

    @Test
    void addLesson_NullLesson() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLesson(null, "Smith"));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    @Test
    void addLesson_TeacherNotFound() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setSubject("Math");

        when(teacherRepository.findByLastName("Smith"))
                .thenReturn(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLesson(lessonEntity, "Smith"));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    @Test
    void addLessons_Success() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setSubject("Math");
        List<LessonEntity> lessonEntities = Collections.singletonList(lessonEntity);

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName("Smith");

        when(teacherRepository.findByLastName("Smith"))
                .thenReturn(teacherEntity);

        when(lessonRepository.save(any(LessonEntity.class)))
                .thenReturn(lessonEntity);

        // Act
        lessonService.addLessons(lessonEntities, "Smith");

        // Assert
        verify(lessonRepository, times(1)).save(lessonEntity);
    }

    @Test
    void addLessons_NullLessonList() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(null, "Smith"));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    @Test
    void addLessons_TeacherNotFound() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setSubject("Math");
        List<LessonEntity> lessonEntities = Collections.singletonList(lessonEntity);

        when(teacherRepository.findByLastName("Smith"))
                .thenReturn(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(lessonEntities, "Smith"));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    /*@Test
    void getLessonById_ExistingLesson() {
        // Arrange
        int id = 1;
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(id);

        when(lessonRepository.findById(id))
                .thenReturn(Optional.of(lessonEntity));

        // Act
        LessonDto result = lessonService.getLessonById(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
    }*/

    @Test
    void getLessonById_NonExistingLesson() {
        // Arrange
        int id = 1;

        when(lessonRepository.findById(id))
                .thenReturn(Optional.empty());

        // Act
        LessonDto result = lessonService.getLessonById(id);

        // Assert
        assertNull(result);
    }

    // Add more test cases for other methods as needed
}




