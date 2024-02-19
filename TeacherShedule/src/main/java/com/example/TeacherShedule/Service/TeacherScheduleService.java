package com.example.TeacherShedule.Service;

import com.example.TeacherShedule.Dao.TeacherScheduleDao;
import com.example.TeacherShedule.Dto.ScheduleResponceDto;
import org.springframework.stereotype.Service;

@Service
public class TeacherScheduleService
{
    private final TeacherScheduleDao teacherScheduleDao;

    public TeacherScheduleService(TeacherScheduleDao teacherScheduleDao) {
        this.teacherScheduleDao = teacherScheduleDao;
    }

    public ScheduleResponceDto searchTeacherSchedule(String idName)
    {
        return teacherScheduleDao.searchTeacherSchedule(idName);
    }
}
