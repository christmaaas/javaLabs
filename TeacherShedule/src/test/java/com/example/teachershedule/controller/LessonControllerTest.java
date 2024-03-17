package com.example.teachershedule.controller;

import com.example.teachershedule.cache.LessonCache;
import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.service.LessonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LessonControllerTest {

    @Mock
    private LessonService lessonService;

    @Mock
    private LessonCache lessonCache;

    @InjectMocks
    private LessonController lessonController;

    @Test
    public void testGetLessonById_ExistingId_ReturnsLessonDto() {
        // Arrange
        int id = 1;
        LessonDto expectedLessonDto = new LessonDto();
        when(lessonCache.getLessonResponse(id)).thenReturn(expectedLessonDto);

        // Act
        LessonDto actualLessonDto = lessonController.getLessonById(id);

        // Assert
        assertNotNull(actualLessonDto);
        assertEquals(expectedLessonDto, actualLessonDto);
    }

    @Test
    public void testGetLessonById_NonExistingId_ReturnsNull() {
        // Arrange
        int id = 1;
        when(lessonCache.getLessonResponse(id)).thenReturn(null);
        when(lessonService.getLessonById(id)).thenReturn(null);

        // Act
        LessonDto actualLessonDto = lessonController.getLessonById(id);

        // Assert
        assertNull(actualLessonDto);
    }

    @Test
    public void testAddLesson_ValidInput_ReturnsOkResponse() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        String teacher = "John Doe";
        when(lessonService.addLesson(lessonEntity, teacher)).thenReturn(lessonEntity);

        // Act
        ResponseEntity<String> response = lessonController.addLesson(lessonEntity, teacher);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody());
    }

    @Test
    public void testAddLesson_NullInput_ReturnsBadRequest() {
        // Arrange
        LessonEntity lessonEntity = null;
        String teacher = "John Doe";

        // Act
        ResponseEntity<String> response = lessonController.addLesson(lessonEntity, teacher);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("error", response.getBody());
    }

    @Test
    public void testGetLessonsByTeacherLastNameAndDayOfWeek_ValidInput_ReturnsDayLessonDtoList() {
        // Arrange
        String teacherLastName = "Doe";
        String dayOfWeek = "Monday";
        List<DayLessonDto> expectedDayLessonDtoList = new ArrayList<>();
        when(lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek))
                .thenReturn(expectedDayLessonDtoList);

        // Act
        List<DayLessonDto> actualDayLessonDtoList = lessonController.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);

        // Assert
        assertNotNull(actualDayLessonDtoList);
        assertEquals(expectedDayLessonDtoList, actualDayLessonDtoList);
    }

    @Test
    public void testGetLessonsByTeacherLastNameAndDayOfWeek_InvalidInput_ReturnsEmptyList() {
        // Arrange
        String teacherLastName = "Doe";
        String dayOfWeek = "Monday";
        when(lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek))
                .thenReturn(null);

        // Act
        List<DayLessonDto> actualDayLessonDtoList = lessonController.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);

        // Assert
        assertNotNull(actualDayLessonDtoList);
        assertTrue(actualDayLessonDtoList.isEmpty());
    }
}
