package com.example.teachershedule.service;

import com.example.teachershedule.dao.GroupRepository;
import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dto.ScheduleDto;
import com.example.teachershedule.dto.ScheduleResponseDto;
import com.example.teachershedule.dto.StudentGroupDto;
import com.example.teachershedule.entity.GroupEntity;
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
    private final GroupRepository groupRepository;

    public TeacherScheduleService(TeacherScheduleRepository teacherScheduleRepository,
                                  LessonRepository lessonRepository,
                                  GroupRepository groupRepository)
    {
        this.teacherScheduleRepository = teacherScheduleRepository;
        this.lessonRepository = lessonRepository;
        this.groupRepository = groupRepository;
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
                lessonEntity.setTime(schedule.getStartLessonTime());
                lessonEntity.setTeacher(teacherEntity);

                lessonRepository.save(lessonEntity);

                saveGroup(scheduleResponseDto, lessonEntity);
            }
        }
    }

    private void saveGroup(ScheduleResponseDto scheduleResponseDto, LessonEntity lessonEntity) {
        for (Map.Entry<String, List<ScheduleDto>> entry : scheduleResponseDto.getSchedules().entrySet())
        {
            List<ScheduleDto> scheduleList = entry.getValue();

            for (ScheduleDto schedule : scheduleList) {
                for(StudentGroupDto studentGroupDto : schedule.getStudentGroups())
                {
                    GroupEntity groupEntity = groupRepository.findByName(String.valueOf(studentGroupDto.getName()));

                    if(groupEntity == null) {
                        groupEntity = new GroupEntity();
                        groupEntity.setSpecialityName(studentGroupDto.getSpecialityName());
                        groupEntity.setSpecialityCode(studentGroupDto.getSpecialityCode());
                        groupEntity.setName(String.valueOf(studentGroupDto.getName()));
                        groupEntity.setNumberOfStudents(studentGroupDto.getNumberOfStudents());
                        groupEntity.setEducationDegree(studentGroupDto.getEducationDegree());

                        groupEntity.getLessons().add(lessonEntity);

                        groupRepository.save(groupEntity);
                    } else {
                        groupEntity.getLessons().add(lessonEntity);
                    }
                }
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
        existingEntity.setLastName(teacherEntity.getLastName());
        existingEntity.setEmail(teacherEntity.getEmail());

        return teacherScheduleRepository.save(existingEntity);
    }

    public void deleteSchedule(int id) {
        teacherScheduleRepository.deleteById(id);
    }
}