package com.example.teachershedule.service;

import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final TeacherScheduleRepository teacherRepository;

    private static final String ERROR = "error";

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

    public LessonDto  getLessonById(int id) {
        LessonEntity lessonEntity = lessonRepository.getById(id);
        return convertToDto(lessonEntity);
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
        existingEntity.setTime(lessonEntity.getTime());

        return lessonRepository.save(existingEntity);

    }

    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }

    private LessonDto convertToDto(LessonEntity lessonEntity) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setTime(lessonEntity.getTime());
        lessonDto.setSubject(lessonEntity.getSubject());
        return lessonDto;
    }
}
