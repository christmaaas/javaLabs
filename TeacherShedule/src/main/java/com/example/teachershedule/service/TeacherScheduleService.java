package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dto.ScheduleDto;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TeacherScheduleService
{
    private final TeacherScheduleRepository teacherScheduleRepository;
    private final LessonRepository lessonRepository;

    public TeacherScheduleService(TeacherScheduleRepository teacherScheduleRepository,
                                  LessonRepository lessonRepository)
    {
        this.teacherScheduleRepository = teacherScheduleRepository;
        this.lessonRepository = lessonRepository;
    }

    public ScheduleResponseDto searchTeacherSchedule(String teacherId)
    {
        String apiRequest = "https://iis.bsuir.by/api/v1/employees/schedule/" + teacherId;

        RestTemplate restTemplate = new RestTemplate();

        ScheduleResponseDto scheduleResponseDto = restTemplate.getForObject(apiRequest, ScheduleResponseDto.class);

        if (scheduleResponseDto != null)
        {
            TeacherEntity teacherEntity = teacherScheduleRepository
                    .findByEmail(scheduleResponseDto.getEmployeeDto().getEmail());

            if(teacherEntity == null)
            {
                teacherEntity = new TeacherEntity();
                teacherEntity.setId(scheduleResponseDto.getEmployeeDto().getId());
                teacherEntity.setFirstName(scheduleResponseDto.getEmployeeDto().getFirstName());
                teacherEntity.setMiddleName(scheduleResponseDto.getEmployeeDto().getMiddleName());
                teacherEntity.setLastName(scheduleResponseDto.getEmployeeDto().getLastName());
                teacherEntity.setEmail(scheduleResponseDto.getEmployeeDto().getEmail());

                teacherScheduleRepository.save(teacherEntity);

                saveLessons(scheduleResponseDto, teacherEntity);
            }
        } else
            return null;

        return scheduleResponseDto;
    }

    private void saveLessons(ScheduleResponseDto scheduleResponseDto, TeacherEntity teacherEntity)
    {
        for (Map.Entry<String, List<ScheduleDto>> entry : scheduleResponseDto.getSchedules().entrySet()) {

            String key = entry.getKey();
            List<ScheduleDto> scheduleList = entry.getValue();

            for (ScheduleDto schedule : scheduleList) {
                LessonEntity lessonEntity = new LessonEntity();
                lessonEntity.setSubject(schedule.getSubject());
                lessonEntity.setSubjectFull(schedule.getSubjectFullName());
                lessonEntity.setDay(key);
                lessonEntity.setStartTime(schedule.getStartLessonTime());
                lessonEntity.setEndTime(schedule.getEndLessonTime());
                lessonEntity.setTeacher(teacherEntity);

                lessonRepository.save(lessonEntity);
            }
        }
    }

    public TeacherEntity createSchedule(TeacherEntity teacherEntity) {
        if (teacherEntity == null || teacherScheduleRepository.findByEmail(teacherEntity.getEmail()) != null) {
            throw new IllegalArgumentException("error");
        }

        return teacherScheduleRepository.save(teacherEntity);
    }

    public TeacherEntity updateSchedule(int id, TeacherEntity teacherEntity) {
        if (teacherEntity == null || teacherScheduleRepository.findByEmail(teacherEntity.getEmail()) != null) {
            throw new IllegalArgumentException("error");
        }

        Optional<TeacherEntity> existingEntityOptional = teacherScheduleRepository.findById(id);
        if (existingEntityOptional.isEmpty()) {
            throw new IllegalArgumentException("id=" + id + " not found");
        }

        TeacherEntity existingEntity = existingEntityOptional.get();

        existingEntity.setFirstName(teacherEntity.getFirstName());
        existingEntity.setMiddleName(teacherEntity.getMiddleName());
        existingEntity.setLastName(teacherEntity.getLastName());
        existingEntity.setEmail(teacherEntity.getEmail());

        return teacherScheduleRepository.save(existingEntity);
    }

    public void deleteSchedule(int id) {
        teacherScheduleRepository.deleteById(id);
    }
}