package com.example.TeacherShedule.Controller;

import com.example.TeacherShedule.Dto.ScheduleResponceDto;
import com.example.TeacherShedule.Service.TeacherScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherScheduleController
{
    private final TeacherScheduleService teacherScheduleService;

    public TeacherScheduleController(TeacherScheduleService teacherScheduleService) {
        this.teacherScheduleService = teacherScheduleService;
    }

    @GetMapping("/employees/schedule/{urlId}")
    public ScheduleResponceDto getEmployeeSchedule(@PathVariable String urlId)
    {
        return teacherScheduleService.searchTeacherSchedule(urlId);
    }
}
