package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.entity.TeacherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

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

    @Test
    void createSchedule_Success() {
        TeacherEntity teacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepository.save(any())).thenReturn(teacherEntity);

        TeacherEntity result = teacherScheduleService.createSchedule(new TeacherEntity());


        assertNotNull(result);
        verify(teacherScheduleRepository, times(1)).save(any());
    }

    @Test
    void createSchedule_NullTeacherEntity() {
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.createSchedule(null));
    }

    @Test
    void updateSchedule_Success() {
        int id = 1;
        TeacherEntity existingTeacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findById(id)).thenReturn(java.util.Optional.of(existingTeacherEntity));
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(null);
        when(teacherScheduleRepository.save(any())).thenReturn(existingTeacherEntity);

        TeacherEntity result = teacherScheduleService.updateSchedule(id, new TeacherEntity());

        assertNotNull(result);
        verify(teacherScheduleRepository, times(1)).save(any());
    }

    @Test
    void updateSchedule_NullTeacherEntity() {
        assertThrows(IllegalArgumentException.class, () -> teacherScheduleService.updateSchedule(1, null));
    }

    @Test
    void updateSchedule_EmailAlreadyExists() {
        int id = 1;
        TeacherEntity existingTeacherEntity = new TeacherEntity();
        when(teacherScheduleRepository.findByEmail(anyString())).thenReturn(existingTeacherEntity);

        Executable updateScheduleExecution = () -> teacherScheduleService.updateSchedule(id, new TeacherEntity());
        assertThrows(IllegalArgumentException.class, updateScheduleExecution);
    }


    @Test
    void updateSchedule_TeacherNotFound() {
        int id = 1;
        when(teacherScheduleRepository.findById(id)).thenReturn(java.util.Optional.empty());

        Executable updateScheduleExecution = () -> teacherScheduleService.updateSchedule(id, new TeacherEntity());
        assertThrows(IllegalArgumentException.class, updateScheduleExecution);
    }


    @Test
    void deleteSchedule_Success() {
        int id = 1;

        assertDoesNotThrow(() -> teacherScheduleService.deleteSchedule(id));

        verify(teacherScheduleRepository, times(1)).deleteById(id);
    }
}
