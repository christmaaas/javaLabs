package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.entity.TeacherEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeacherScheduleServiceTests {

    /*@Mock
    private TeacherScheduleRepository teacherScheduleRepository;

    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TeacherScheduleService teacherScheduleService;*/

    /*@Test
    public void testSearchTeacherSchedule_Success() {
        // Arrange
        String teacherId = "123456";
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        when(restTemplate.getForObject(anyString(), eq(ScheduleResponseDto.class))).thenReturn(scheduleResponseDto);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNotNull(result);
        verify(teacherScheduleRepository, times(1)).save(any(TeacherEntity.class));
        verify(lessonRepository, times(1)).save(any());
    }

    @Test
    public void testSearchTeacherSchedule_NoResponse() {
        // Arrange
        String teacherId = "123456";
        when(restTemplate.getForObject(anyString(), eq(ScheduleResponseDto.class))).thenReturn(null);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNull(result);
        verify(teacherScheduleRepository, never()).save(any());
        verify(lessonRepository, never()).save(any());
    }

    @Test
    public void testCreateSchedule_Success() {
        // Arrange
        TeacherEntity teacherEntity = new TeacherEntity();

        // Act
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepository.save(any(TeacherEntity.class))).thenReturn(new TeacherEntity());
        TeacherEntity result = teacherScheduleService.createSchedule(teacherEntity);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testCreateSchedule_InvalidInput() {
        // Arrange
        TeacherEntity teacherEntity = new TeacherEntity();

        // Act + Assert
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(new TeacherEntity());
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.createSchedule(teacherEntity));
        verify(teacherScheduleRepository, never()).save(any(TeacherEntity.class));
    }*/

    // Добавьте другие тесты для остальных методов TeacherScheduleService
}


