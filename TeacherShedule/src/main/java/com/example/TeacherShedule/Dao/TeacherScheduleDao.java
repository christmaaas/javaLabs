package com.example.TeacherShedule.Dao;

import com.example.TeacherShedule.Dto.ScheduleResponceDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TeacherScheduleDao
{
    public ScheduleResponceDto searchTeacherSchedule(String idName)
    {
        String apiUrl = "https://iis.bsuir.by/api/v1/employees/schedule/"
                + idName;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(apiUrl, ScheduleResponceDto.class);
    }
}
