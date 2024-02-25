package com.example.teachershedule.controller;

import com.example.teachershedule.dto.ScheduleResponceDto;
import com.example.teachershedule.service.TeacherScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherScheduleController
{
    private final TeacherScheduleService teacherScheduleService;

    public TeacherScheduleController(TeacherScheduleService teacherScheduleService) {
        this.teacherScheduleService = teacherScheduleService;
    }

    @GetMapping("/get-schedule")
    public ScheduleResponceDto getEmployeeSchedule(@RequestParam() String apiUrl, @RequestParam() String teacherId)
    {
        return teacherScheduleService.searchTeacherSchedule(apiUrl, teacherId);
    }
}
