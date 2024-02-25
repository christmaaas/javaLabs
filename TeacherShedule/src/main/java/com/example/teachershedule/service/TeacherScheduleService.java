package com.example.teachershedule.service;

import com.example.teachershedule.dto.ScheduleResponceDto;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TeacherScheduleService
{
    private final TeacherScheduleRepository teacherScheduleRepository;

    public TeacherScheduleService(TeacherScheduleRepository teacherScheduleRepository) {
        this.teacherScheduleRepository = teacherScheduleRepository;
    }

    public ScheduleResponceDto searchTeacherSchedule(String teacherId)
    {
        String apiRequest = "https://iis.bsuir.by/api/v1/employees/schedule/" + teacherId;

        RestTemplate restTemplate = new RestTemplate();

        ScheduleResponceDto scheduleResponceDto = restTemplate.getForObject(apiRequest, ScheduleResponceDto.class);

        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(scheduleResponceDto.getEmployeeDto().getId());
        teacher.setFirstName(scheduleResponceDto.getEmployeeDto().getFirstName());
        teacher.setLastName(scheduleResponceDto.getEmployeeDto().getLastName());
        teacher.setEmail(scheduleResponceDto.getEmployeeDto().getEmail());

        teacherScheduleRepository.save(teacher);

        return scheduleResponceDto;
    }
}
