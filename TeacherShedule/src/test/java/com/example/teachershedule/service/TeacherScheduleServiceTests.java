package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.EmployeeDto;
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

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
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
        MockitoAnnotations.initMocks(this);
    }

    /*@Test
    void searchTeacherSchedule_Success() {
        // Arrange
        String teacherId = "12345";
        String teacherEmail = "teacher@example.com";

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(teacherEmail);
        scheduleResponseDto.setEmployeeDto(employeeDto);
        when(restTemplate.getForObject(any(String.class), eq(ScheduleResponseDto.class)))
                .thenReturn(scheduleResponseDto);

        when(teacherScheduleRepository.findByEmail(teacherEmail))
                .thenReturn(null);

        when(teacherScheduleRepository.save(any(TeacherEntity.class)))
                .thenReturn(new TeacherEntity());

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNotNull(result);
        assertEquals(employeeDto, result.getEmployeeDto());
        verify(teacherScheduleRepository, times(1)).save(any(TeacherEntity.class));
    }*/

    /*@Test
    void searchTeacherSchedule_TeacherAlreadyExists() {
        // Arrange
        String teacherId = "12345";
        String teacherEmail = "teacher@example.com";

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(teacherEmail);
        scheduleResponseDto.setEmployeeDto(employeeDto);
        when(restTemplate.getForObject(any(String.class), eq(ScheduleResponseDto.class)))
                .thenReturn(scheduleResponseDto);

        when(teacherScheduleRepository.findByEmail(teacherEmail))
                .thenReturn(new TeacherEntity());

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNotNull(result);
        assertEquals(employeeDto, result.getEmployeeDto());
        verify(teacherScheduleRepository, never()).save(any(TeacherEntity.class));
    }*/

    /*@Test
    void searchTeacherSchedule_NullResponse() {
        // Arrange
        String teacherId = "12345";

        when(restTemplate.getForObject(any(String.class), eq(ScheduleResponseDto.class)))
                .thenReturn(null);

        // Act
        ScheduleResponseDto result = teacherScheduleService.searchTeacherSchedule(teacherId);

        // Assert
        assertNull(result);
        verify(teacherScheduleRepository, never()).findByEmail(any(String.class));
        verify(teacherScheduleRepository, never()).save(any(TeacherEntity.class));
    }*/

    @Test
    void createSchedule_Success() {
        // Arrange
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setEmail("teacher@example.com");
        when(teacherScheduleRepository.findByEmail("teacher@example.com"))
                .thenReturn(null);
        when(teacherScheduleRepository.save(teacherEntity))
                .thenReturn(teacherEntity);

        // Act
        TeacherEntity result = teacherScheduleService.createSchedule(teacherEntity);

        // Assert
        assertNotNull(result);
        assertEquals("teacher@example.com", result.getEmail());
        verify(teacherScheduleRepository, times(1)).save(teacherEntity);
    }

    @Test
    void createSchedule_TeacherAlreadyExists() {
        // Arrange
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setEmail("teacher@example.com");
        when(teacherScheduleRepository.findByEmail("teacher@example.com"))
                .thenReturn(teacherEntity);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.createSchedule(teacherEntity));
        verify(teacherScheduleRepository, never()).save(teacherEntity);
    }

    @Test
    void updateSchedule_Success() {
        // Arrange
        int id = 1;
        TeacherEntity existingEntity = new TeacherEntity();
        existingEntity.setId(id);
        existingEntity.setEmail("teacher@example.com");

        TeacherEntity updatedEntity = new TeacherEntity();
        updatedEntity.setId(id);
        updatedEntity.setEmail("updated@example.com");

        when(teacherScheduleRepository.findByEmail("updated@example.com"))
                .thenReturn(null);

        when(teacherScheduleRepository.findById(id))
                .thenReturn(Optional.of(existingEntity));

        when(teacherScheduleRepository.save(existingEntity))
                .thenReturn(updatedEntity);

        // Act
        TeacherEntity result = teacherScheduleService.updateSchedule(id, updatedEntity);

        // Assert
        assertNotNull(result);
        assertEquals("updated@example.com", result.getEmail());
        verify(teacherScheduleRepository, times(1)).save(existingEntity);
    }

    @Test
    void updateSchedule_TeacherAlreadyExists() {
        // Arrange
        int id = 1;
        TeacherEntity existingEntity = new TeacherEntity();
        existingEntity.setId(id);
        existingEntity.setEmail("teacher@example.com");

        TeacherEntity updatedEntity = new TeacherEntity();
        updatedEntity.setId(id);
        updatedEntity.setEmail("updated@example.com");

        when(teacherScheduleRepository.findByEmail("updated@example.com"))
                .thenReturn(updatedEntity);

        when(teacherScheduleRepository.findById(id))
                .thenReturn(Optional.of(existingEntity));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.updateSchedule(id, updatedEntity));
        verify(teacherScheduleRepository, never()).save(existingEntity);
    }

    @Test
    void updateSchedule_TeacherNotFound() {
        // Arrange
        int id = 1;
        TeacherEntity updatedEntity = new TeacherEntity();
        updatedEntity.setId(id);
        updatedEntity.setEmail("updated@example.com");

        when(teacherScheduleRepository.findById(id))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.updateSchedule(id, updatedEntity));
        verify(teacherScheduleRepository, never()).save(any(TeacherEntity.class));
    }

    @Test
    void deleteSchedule_Success() {
        // Arrange
        int id = 1;
        TeacherEntity existingEntity = new TeacherEntity();
        existingEntity.setId(id);

        when(teacherScheduleRepository.findById(id))
                .thenReturn(Optional.of(existingEntity));

        // Act
        teacherScheduleService.deleteSchedule(id);

        // Assert
        verify(teacherScheduleRepository, times(1)).deleteById(id);
    }

    /*@Test
    void deleteSchedule_TeacherNotFound() {
        // Arrange
        int id = 1;
        when(teacherScheduleRepository.findById(id))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.deleteSchedule(id));
        verify(teacherScheduleRepository, never()).deleteById(id);
    }*/
}






