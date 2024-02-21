package com.example.TeacherShedule.Service;

import com.example.TeacherShedule.Dao.TeacherScheduleDao;
import com.example.TeacherShedule.Dto.ScheduleResponceDto;
import com.example.TeacherShedule.Model.Teacher;
import com.example.TeacherShedule.Repository.TeacherScheduleRepository;
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

        Teacher teacher = new Teacher();
        teacher.setID(scheduleResponceDto.getEmployeeDto().getId());
        teacher.setFirstName(scheduleResponceDto.getEmployeeDto().getFirstName());
        teacher.setLastName(scheduleResponceDto.getEmployeeDto().getLastName());
        teacher.setEmail(scheduleResponceDto.getEmployeeDto().getEmail());

        teacherScheduleRepository.save(teacher);

        return scheduleResponceDto;
    }
}
