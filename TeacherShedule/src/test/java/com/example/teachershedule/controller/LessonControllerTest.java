package com.example.teachershedule.controller;

import com.example.teachershedule.cache.LessonCache;
import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.service.LessonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class LessonControllerTest {

    @Mock
    private LessonService lessonService;

    @Mock
    private LessonCache lessonCache;

    @InjectMocks
    private LessonController lessonController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetLessonById() {
        // Arrange
        int id = 1;
        LessonDto expectedDto = new LessonDto();
        when(lessonCache.getLessonResponse(id)).thenReturn(null);
        when(lessonService.getLessonById(id)).thenReturn(expectedDto);

        // Act
        LessonDto result = lessonController.getLessonById(id);

        // Assert
        assertEquals(expectedDto, result);
        verify(lessonCache, times(1)).saveLessonResponse(id, expectedDto);
    }

    @Test
    void testGetLessonsByTeacherLastNameAndDayOfWeek() {
        // Arrange
        String teacherLastName = "Smith";
        String dayOfWeek = "Monday";
        List<DayLessonDto> expectedList = new ArrayList<>();
        when(lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek)).thenReturn(expectedList);

        // Act
        List<DayLessonDto> result = lessonController.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);

        // Assert
        assertEquals(expectedList, result);
    }

    @Test
    void testAddLesson() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        String teacher = "Smith";
        when(lessonService.addLesson(any(LessonEntity.class), eq(teacher))).thenReturn(new LessonEntity());

        // Act
        ResponseEntity<String> result = lessonController.addLesson(lessonEntity, teacher);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testAddLessons() {
        // Arrange
        List<LessonEntity> lessonEntities = new ArrayList<>();
        String teacher = "Smith";
        doNothing().when(lessonService).addLessons(any(List.class), eq(teacher));

        // Act
        ResponseEntity<String> result = lessonController.addLessons(lessonEntities, teacher);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


    @Test
    void testUpdateLesson() {
        // Arrange
        int id = 1;
        LessonEntity lessonEntity = new LessonEntity();
        when(lessonService.updateLesson(eq(id), any(LessonEntity.class))).thenReturn(new LessonEntity());

        // Act
        ResponseEntity<String> result = lessonController.updateLesson(id, lessonEntity);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void testDeleteLesson() {
        // Arrange
        int id = 1;
        doNothing().when(lessonService).deleteLesson(eq(id));

        // Act
        ResponseEntity<String> result = lessonController.deleteLesson(id);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
