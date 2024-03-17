package com.example.teachershedule.controller;

import com.example.teachershedule.cache.ResponseCache;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.service.TeacherScheduleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeacherScheduleControllerTest {

    @Mock
    private TeacherScheduleService teacherScheduleService;

    @Mock
    private ResponseCache responseCache;

    @InjectMocks
    private TeacherScheduleController teacherScheduleController;

    @Test
    void testGetEmployeeSchedule() {
        String teacherId = "1";
        ScheduleResponseDto expectedResponseDto = new ScheduleResponseDto();
        when(responseCache.getScheduleResponse(teacherId)).thenReturn(expectedResponseDto);

        ScheduleResponseDto actualResponseDto = teacherScheduleController.getEmployeeSchedule(teacherId);

        assertEquals(expectedResponseDto, actualResponseDto);
    }

    @Test
    void testCreateSchedule() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(1);
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.ok("success");
        when(teacherScheduleService.createSchedule(teacherEntity)).thenReturn(teacherEntity);

        ResponseEntity<String> actualResponseEntity = teacherScheduleController.createSchedule(teacherEntity);

        assertEquals(expectedResponseEntity, actualResponseEntity);
    }

    @Test
    void testUpdateSchedule() {
        int id = 1;
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(id);
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.ok("success");
        when(teacherScheduleService.updateSchedule(id, teacherEntity)).thenReturn(teacherEntity);

        ResponseEntity<String> actualResponseEntity = teacherScheduleController.updateSchedule(id, teacherEntity);

        assertEquals(expectedResponseEntity, actualResponseEntity);
    }

    @Test
    void testDeleteSchedule() {
        int id = 1;
        ResponseEntity<String> expectedResponseEntity = ResponseEntity.ok("success");

        ResponseEntity<String> actualResponseEntity = teacherScheduleController.deleteSchedule(id);

        assertEquals(expectedResponseEntity, actualResponseEntity);
    }
}

