package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LessonServiceTests {
    @Mock
    private LessonRepository lessonRepository;

    @Mock
    private TeacherScheduleRepository teacherRepository;

    @InjectMocks
    private LessonService lessonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addLesson_Success() {
        LessonEntity lessonEntity = new LessonEntity();
        String teacherLastName = "Smith";
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName(teacherLastName);
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(teacherEntity);
        when(lessonRepository.save(any())).thenReturn(lessonEntity);

        LessonEntity result = lessonService.addLesson(new LessonEntity(), teacherLastName);

        assertNotNull(result);
        verify(lessonRepository, times(1)).save(any());
    }

    @Test
    void addLesson_NullLessonEntity() {
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLesson(null, "Smith"));
    }

    @Test
    void addLessons_Success() {
        List<LessonEntity> lessonEntities = new ArrayList<>();
        lessonEntities.add(new LessonEntity());
        String teacherLastName = "Smith";
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName(teacherLastName);
        when(teacherRepository.findByLastName(teacherLastName)).thenReturn(teacherEntity);
        when(lessonRepository.save(any())).thenReturn(new LessonEntity());

        assertDoesNotThrow(() -> lessonService.addLessons(lessonEntities, teacherLastName));

        verify(lessonRepository, times(lessonEntities.size())).save(any());
    }

    @Test
    void addLessons_NullLessonEntities() {
        assertThrows(IllegalArgumentException.class, () -> lessonService.addLessons(null, "Smith"));
    }

    @Test
    void addLessons_EmptyLessonEntities() {
        Executable addLessonsExecution = () -> lessonService.addLessons(new ArrayList<>(), "Smith");
        assertThrows(IllegalArgumentException.class, addLessonsExecution);
    }


    @Test
    void getLessonById_NotExists() {
        int lessonId = 1;
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.empty());

        LessonDto result = lessonService.getLessonById(lessonId);

        assertNull(result);
    }

    @Test
    void getLessonsByTeacherLastNameAndDayOfWeek_Success() {
        String teacherLastName = "Smith";
        String dayOfWeek = "Monday";
        List<DayLessonDto> expectedDayLessons = new ArrayList<>();
        when(lessonRepository.findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek))
                .thenReturn(expectedDayLessons);

        List<DayLessonDto> result = lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);

        assertNotNull(result);
        assertEquals(expectedDayLessons, result);
        verify(lessonRepository, times(1)).findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);
    }

    @Test
    void updateLesson_Success() {
        int lessonId = 1;
        LessonEntity lessonEntity = new LessonEntity();
        LessonEntity updatedLessonEntity = new LessonEntity();
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.of(lessonEntity));
        when(lessonRepository.save(any())).thenReturn(updatedLessonEntity);

        LessonEntity result = lessonService.updateLesson(lessonId, new LessonEntity());

        assertNotNull(result);
        verify(lessonRepository, times(1)).save(any());
    }

    @Test
    void updateLesson_NullLessonEntity() {
        assertThrows(IllegalArgumentException.class, () -> lessonService.updateLesson(1, null));
    }

    @Test
    void updateLesson_NotFound() {
        int lessonId = 1;
        when(lessonRepository.findById(lessonId)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> lessonService.updateLesson(lessonId, new LessonEntity()));
    }

    @Test
    void deleteLesson_Success() {
        int lessonId = 1;

        assertDoesNotThrow(() -> lessonService.deleteLesson(lessonId));

        verify(lessonRepository, times(1)).deleteById(lessonId);
    }
}






