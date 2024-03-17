package com.example.teachershedule.service;

import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LessonServiceTests {

    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private TeacherScheduleRepository teacherRepository;

    @InjectMocks
    private LessonService lessonService;

    @Test
    public void testAddLesson_Success() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        TeacherEntity teacherEntity = new TeacherEntity();
        String teacherLastName = "Smith";
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(teacherEntity);
        when(lessonRepository.save(any(LessonEntity.class))).thenReturn(new LessonEntity());

        // Act
        LessonEntity result = lessonService.addLesson(lessonEntity, teacherLastName);

        // Assert
        assertNotNull(result);
        verify(lessonRepository, times(1)).save(any(LessonEntity.class));
    }

    @Test
    public void testAddLesson_InvalidLesson() {
        // Arrange
        String teacherLastName = "Smith";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLesson(null, teacherLastName));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    @Test
    public void testAddLesson_InvalidTeacher() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        String teacherLastName = "Smith";
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(null);

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLesson(lessonEntity, teacherLastName));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    /*@Test
    public void testAddLessons_Success() {
        // Arrange
        List<LessonEntity> lessonEntities = new ArrayList<>();
        TeacherEntity teacherEntity = new TeacherEntity();
        String teacherLastName = "Smith";
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(teacherEntity);
        when(lessonRepository.save(any(LessonEntity.class))).thenReturn(new LessonEntity());

        // Act
        assertDoesNotThrow(() -> lessonService.addLessons(lessonEntities, teacherLastName));

        // Assert
        verify(lessonRepository, times(lessonEntities.size())).save(any(LessonEntity.class));
    }*/

    @Test
    public void testAddLessons_InvalidInput() {
        // Arrange
        List<LessonEntity> lessonEntities = null;
        String teacherLastName = "Smith";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(lessonEntities, teacherLastName));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    /*@Test
    public void testAddLessons_InvalidTeacher() {
        // Arrange
        List<LessonEntity> lessonEntities = new ArrayList<>();
        String teacherLastName = "Smith";
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(null);

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(lessonEntities, teacherLastName));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }*/

    // Добавьте другие тесты для остальных методов LessonService
}



