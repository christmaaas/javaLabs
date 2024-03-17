package com.example.teachershedule.service;

import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TeacherScheduleRepository teacherRepository;

    private static final String ERROR = "error";

    private static final Logger logger = LoggerFactory.getLogger(LessonService.class);


    @Autowired
    public LessonService(LessonRepository lessonRepository, TeacherScheduleRepository teacherRepository) {
        this.lessonRepository = lessonRepository;
        this.teacherRepository = teacherRepository;
    }

    public LessonEntity addLesson(LessonEntity lessonEntity, String teacher) {
        if (lessonEntity == null) {
            throw new IllegalArgumentException(ERROR);
        }

        TeacherEntity teacherEntity = teacherRepository.findByLastName(teacher);
        if(teacherEntity != null) {
            lessonEntity.setTeacher(teacherEntity);

            return lessonRepository.save(lessonEntity);
        } else {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public void addLessons(List<LessonEntity> lessonEntities, String teacher) {
        if (lessonEntities == null || lessonEntities.isEmpty()) {
            throw new IllegalArgumentException(ERROR);
        }

        TeacherEntity teacherEntity = teacherRepository.findByLastName(teacher);
        if (teacherEntity == null) {
            throw new IllegalArgumentException(ERROR);
        }

        lessonEntities.stream()
                .map(lessonEntity -> {
                    lessonEntity.setTeacher(teacherEntity);
                    return lessonRepository.save(lessonEntity);
                })
                .forEach(savedLessonEntity -> {
                    logger.info("Lesson saved ID: {}", savedLessonEntity.getId());
                });
    }

    public LessonDto getLessonById(int id) {

        Optional<LessonEntity> auditoryOptional = lessonRepository.findById(id);

        if (auditoryOptional.isPresent()) {
            return convertToDto(auditoryOptional.get());
        } else {
            return null;
        }
    }

    public List<DayLessonDto> getLessonsByTeacherLastNameAndDayOfWeek(String teacherLastName, String dayOfWeek) {
        return lessonRepository.findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);
    }

    public LessonEntity updateLesson(int id, LessonEntity lessonEntity) {
        if (lessonEntity == null) {
            throw new IllegalArgumentException(ERROR);
        }

        Optional<LessonEntity> existingEntityOptional = lessonRepository.findById(id);
        if (existingEntityOptional.isEmpty()) {
            throw new IllegalArgumentException("id=" + id + " not found");
        }

        LessonEntity existingEntity = existingEntityOptional.get();

        existingEntity.setSubject(lessonEntity.getSubject());
        existingEntity.setStartTime(lessonEntity.getStartTime());
        existingEntity.setEndTime(lessonEntity.getEndTime());
        existingEntity.setDay(lessonEntity.getDay());
        existingEntity.setSubjectFull(lessonEntity.getSubjectFull());

        return lessonRepository.save(existingEntity);

    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }

    private LessonDto convertToDto(LessonEntity lessonEntity) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lessonEntity.getId());
        lessonDto.setStartTime(lessonEntity.getStartTime());
        lessonDto.setEndTime(lessonEntity.getEndTime());
        lessonDto.setSubject(lessonEntity.getSubject());
        lessonDto.setSubjectFull(lessonEntity.getSubjectFull());
        lessonDto.setDay(lessonEntity.getDay());
        lessonDto.setTeacherId(lessonEntity.getTeacher().getId());
        return lessonDto;
    }
}
