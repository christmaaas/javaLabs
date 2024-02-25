package com.example.teachershedule.service;

import com.example.teachershedule.dao.TeacherScheduleDao;
import com.example.teachershedule.dto.ScheduleResponceDto;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherScheduleService
{
    private final TeacherScheduleDao teacherScheduleDao;
    private final TeacherScheduleRepository teacherScheduleRepository;

    public TeacherScheduleService(TeacherScheduleDao teacherScheduleDao, TeacherScheduleRepository teacherScheduleRepository) {
        this.teacherScheduleDao = teacherScheduleDao;
        this.teacherScheduleRepository = teacherScheduleRepository;
    }

    public ScheduleResponceDto searchTeacherSchedule(String idName)
    {
        ScheduleResponceDto scheduleResponceDto = teacherScheduleDao.searchTeacherSchedule(idName);

        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(scheduleResponceDto.getEmployeeDto().getId());
        teacher.setFirstName(scheduleResponceDto.getEmployeeDto().getFirstName());
        teacher.setLastName(scheduleResponceDto.getEmployeeDto().getLastName());
        teacher.setEmail(scheduleResponceDto.getEmployeeDto().getEmail());

        teacherScheduleRepository.save(teacher);

        return scheduleResponceDto;
    }
}
