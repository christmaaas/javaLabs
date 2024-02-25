package com.example.teachershedule.dao;

import com.example.teachershedule.dto.ScheduleResponceDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TeacherScheduleDao
{
    public ScheduleResponceDto searchTeacherSchedule(String apiUrl, String teacherId)
    {
        String apiRequest = apiUrl + teacherId;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiRequest, ScheduleResponceDto.class);
    }
}
