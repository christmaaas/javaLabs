package com.example.teachershedule.dao;

import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends JpaRepository<LessonEntity, Integer>
{
    @Query("SELECT new com.example.teachershedule.dto.DayLessonDto(l.subject, l.subjectFull, l.startTime, l.endTime) " +
            "FROM LessonEntity l " +
            "WHERE l.teacher.lastName = :teacherLastName " +
            "AND l.day = :dayOfWeek")
    List<DayLessonDto> findDayLessonsByTeacherLastNameAndDayOfWeek(@Param("teacherLastName") String teacherLastName, @Param("dayOfWeek") String dayOfWeek);
}
