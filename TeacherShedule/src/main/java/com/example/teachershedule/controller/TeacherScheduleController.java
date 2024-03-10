package com.example.teachershedule.controller;

import com.example.teachershedule.cache.ResponseCache;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.service.TeacherScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class TeacherScheduleController
{
    private final TeacherScheduleService teacherScheduleService;
    private final ResponseCache responseCache;

    private static final String ACTION = "success";

    public TeacherScheduleController(TeacherScheduleService teacherScheduleService,
                                     ResponseCache responseCache) {
        this.teacherScheduleService = teacherScheduleService;
        this.responseCache = responseCache;
    }

    @GetMapping("/get")
    public ScheduleResponseDto getEmployeeSchedule(@RequestParam(value = "teacherId") String teacherId)
    {
        ScheduleResponseDto scheduleResponseDto = responseCache.getScheduleResponse(teacherId);

        if(scheduleResponseDto != null){
            return scheduleResponseDto;
        } else {
            scheduleResponseDto = teacherScheduleService.searchTeacherSchedule(teacherId);
            responseCache.saveScheduleResponse(teacherId, scheduleResponseDto);
            return scheduleResponseDto;
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createSchedule(@RequestBody TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return ResponseEntity.badRequest().body("error");
        }
        try {
            teacherScheduleService.createSchedule(teacherEntity);

            return ResponseEntity.ok(ACTION);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable("id") int id, @RequestBody TeacherEntity teacherEntity) {
        if (teacherEntity == null) {
            return ResponseEntity.badRequest().body("error");
        }

        try {
            teacherScheduleService.updateSchedule(id, teacherEntity);

            return ResponseEntity.ok(ACTION);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable("id") int id) {
        try {
            teacherScheduleService.deleteSchedule(id);

            return ResponseEntity.ok(ACTION);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

