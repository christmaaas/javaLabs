package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
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
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addLesson_Success() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        String teacherLastName = "Smith";
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName(teacherLastName);
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(teacherEntity);
        when(lessonRepository.save(any())).thenReturn(lessonEntity);

        // Act
        LessonEntity result = lessonService.addLesson(new LessonEntity(), teacherLastName);

        // Assert
        assertNotNull(result);
        verify(lessonRepository, times(1)).save(any());
    }

    @Test
    void addLesson_NullLessonEntity() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLesson(null, "Smith"));
    }

    @Test
    void addLessons_Success() {
        // Arrange
        List<LessonEntity> lessonEntities = new ArrayList<>();
        lessonEntities.add(new LessonEntity());
        String teacherLastName = "Smith";
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName(teacherLastName);
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(teacherEntity);
        when(lessonRepository.save(any())).thenReturn(new LessonEntity());

        // Act
        assertDoesNotThrow(() -> lessonService.addLessons(lessonEntities, teacherLastName));

        // Assert
        verify(lessonRepository, times(lessonEntities.size())).save(any());
    }

    @Test
    void addLessons_NullLessonEntities() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(null, "Smith"));
    }

    @Test
    void addLessons_EmptyLessonEntities() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(new ArrayList<>(), "Smith"));
    }

    /*@Test
    void getLessonById_Exists() {
        // Arrange
        int lessonId = 1;
        LessonEntity lessonEntity = new LessonEntity();
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.of(lessonEntity));

        // Act
        LessonDto result = lessonService.getLessonById(lessonId);

        // Assert
        assertNotNull(result);
    }*/

    @Test
    void getLessonById_NotExists() {
        // Arrange
        int lessonId = 1;
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.empty());

        // Act
        LessonDto result = lessonService.getLessonById(lessonId);

        // Assert
        assertNull(result);
    }

    @Test
    void getLessonsByTeacherLastNameAndDayOfWeek_Success() {
        // Arrange
        String teacherLastName = "Smith";
        String dayOfWeek = "Monday";
        List<DayLessonDto> expectedDayLessons = new ArrayList<>();
        when(lessonRepository.findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek))
                .thenReturn(expectedDayLessons);

        // Act
        List<DayLessonDto> result = lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDayLessons, result);
        verify(lessonRepository, times(1)).findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);
    }

    @Test
    void updateLesson_Success() {
        // Arrange
        int lessonId = 1;
        LessonEntity lessonEntity = new LessonEntity();
        LessonEntity updatedLessonEntity = new LessonEntity();
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.of(lessonEntity));
        when(lessonRepository.save(any())).thenReturn(updatedLessonEntity);

        // Act
        LessonEntity result = lessonService.updateLesson(lessonId, new LessonEntity());

        // Assert
        assertNotNull(result);
        verify(lessonRepository, times(1)).save(any());
    }

    @Test
    void updateLesson_NullLessonEntity() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.updateLesson(1, null));
    }

    @Test
    void updateLesson_NotFound() {
        // Arrange
        int lessonId = 1;
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.empty());

        // Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.updateLesson(lessonId, new LessonEntity()));
    }

    @Test
    void deleteLesson_Success() {
        // Arrange
        int lessonId = 1;

        // Act
        assertDoesNotThrow(() -> lessonService.deleteLesson(lessonId));

        // Assert
        verify(lessonRepository, times(1)).deleteById(lessonId);
    }
}






