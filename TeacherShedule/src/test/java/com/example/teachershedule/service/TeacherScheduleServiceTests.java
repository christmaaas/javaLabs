package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.ScheduleDto;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.entity.TeacherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeacherScheduleServiceTests {

    @Mock
    private TeacherScheduleRepository teacherScheduleRepository;

    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TeacherScheduleService teacherScheduleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    void searchTeacherSchedule_Success() {
        // Arrange
        String teacherId = "123";
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        when(restTemplate.getForObject(anyString(), eq(ScheduleResponseDto.class))).thenReturn(scheduleResponseDto);
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(null);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNotNull(result);
        verify(teacherScheduleRepository, times(1)).save(any());
        verify(lessonRepository, times(1)).save(any());
    }*/

    /*@Test
    void searchTeacherSchedule_NoScheduleResponse() {
        // Arrange
        String teacherId = "123";
        when(restTemplate.getForObject(anyString(), eq(ScheduleResponseDto.class))).thenReturn(null);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNull(result);
    }*/

    @Test
    void createSchedule_Success() {
        // Arrange
        TeacherEntity teacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepository.save(any())).thenReturn(teacherEntity);

        // Act
        TeacherEntity result = teacherScheduleService.createSchedule(new TeacherEntity());

        // Assert
        assertNotNull(result);
        verify(teacherScheduleRepository, times(1)).save(any());
    }

    @Test
    void createSchedule_NullTeacherEntity() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.createSchedule(null));
    }

    /*@Test
    void createSchedule_EmailAlreadyExists() {
        // Arrange
        TeacherEntity existingTeacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(existingTeacherEntity);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.createSchedule(new TeacherEntity()));
    }*/



    @Test
    void updateSchedule_Success() {
        // Arrange
        int id = 1;
        TeacherEntity existingTeacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findById(id)).thenReturn(java.util.Optional.of(existingTeacherEntity));
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepository.save(any())).thenReturn(existingTeacherEntity);

        // Act
        TeacherEntity result = teacherScheduleService.updateSchedule(id, new TeacherEntity());

        // Assert
        assertNotNull(result);
        verify(teacherScheduleRepository, times(1)).save(any());
    }

    @Test
    void updateSchedule_NullTeacherEntity() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.updateSchedule(1, null));
    }

    @Test
    void updateSchedule_EmailAlreadyExists() {
        // Arrange
        int id = 1;
        TeacherEntity existingTeacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(existingTeacherEntity);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.updateSchedule(id, new TeacherEntity()));
    }

    @Test
    void updateSchedule_TeacherNotFound() {
        // Arrange
        int id = 1;
        when(teacherScheduleRepository.findById(id)).thenReturn(java.util.Optional.empty());

        // Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.updateSchedule(id, new TeacherEntity()));
    }

    @Test
    void deleteSchedule_Success() {
        // Arrange
        int id = 1;

        // Act
        assertDoesNotThrow(() -> teacherScheduleService.deleteSchedule(id));

        // Assert
        verify(teacherScheduleRepository, times(1)).deleteById(id);
    }
}
