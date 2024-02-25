package com.example.teachershedule.dao;

import com.example.teachershedule.dto.ScheduleResponceDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TeacherScheduleDao
{
    public ScheduleResponceDto searchTeacherSchedule(String teacherId)
    {
        String apiRequest = "https://iis.bsuir.by/api/v1/employees/schedule/" + teacherId;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiRequest, ScheduleResponceDto.class);
    }
}
