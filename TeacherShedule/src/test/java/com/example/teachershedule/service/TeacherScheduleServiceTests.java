package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.ScheduleDto;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.service.TeacherScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeacherScheduleServiceTests {

    /*@Mock
    private TeacherScheduleRepository teacherScheduleRepositoryMock;

    @Mock
    private LessonRepository lessonRepositoryMock;

    @Mock
    private RestTemplate restTemplateMock;

    @InjectMocks
    private TeacherScheduleService teacherScheduleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSearchTeacherSchedule_ReturnsScheduleResponseDto() {
        // Arrange
        String teacherId = "123";
        ScheduleResponseDto scheduleResponseDtoMock = mock(ScheduleResponseDto.class);
        when(restTemplateMock.getForObject(anyString(), eq(ScheduleResponseDto.class))).thenReturn(scheduleResponseDtoMock);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertEquals(scheduleResponseDtoMock, result);
    }


    @Test
    void testSearchTeacherSchedule_CreatesTeacherEntityAndSavesLessons() {
        // Arrange
        String teacherId = "123";
        ScheduleResponseDto scheduleResponseDtoMock = mock(ScheduleResponseDto.class);
        TeacherEntity teacherEntityMock = mock(TeacherEntity.class);
        when(scheduleResponseDtoMock.getEmployeeDto().getEmail()).thenReturn("teacher@example.com");
        when(teacherScheduleRepositoryMock.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepositoryMock.save(any(TeacherEntity.class))).thenReturn(teacherEntityMock);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNotNull(result);
        verify(teacherScheduleRepositoryMock).save(teacherEntityMock);
        verify(lessonRepositoryMock, atLeastOnce()).save(any(LessonEntity.class));
    }

    @Test
    void testCreateSchedule_ReturnsTeacherEntity() {
        // Arrange
        TeacherEntity teacherEntityMock = mock(TeacherEntity.class);
        when(teacherScheduleRepositoryMock.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepositoryMock.save(any(TeacherEntity.class))).thenReturn(teacherEntityMock);

        // Act
        TeacherEntity result = teacherScheduleService.createSchedule(teacherEntityMock);

        // Assert
        assertEquals(teacherEntityMock, result);
    }

    @Test
    void testCreateSchedule_ThrowsIllegalArgumentExceptionWhenTeacherExists() {
        // Arrange
        TeacherEntity teacherEntityMock = mock(TeacherEntity.class);
        when(teacherScheduleRepositoryMock.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepositoryMock.findByEmail(eq("teacher@example.com"))).thenReturn(teacherEntityMock);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.createSchedule(teacherEntityMock));
    }*/


    // Add more tests for other methods if necessary
}





