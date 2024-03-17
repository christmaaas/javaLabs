package com.example.teachershedule.service;

import com.example.teachershedule.dao.LessonRepository;
import com.example.teachershedule.dao.TeacherScheduleRepository;
import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.entity.TeacherEntity;
import com.example.teachershedule.service.LessonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getLessonsByTeacherLastNameAndDayOfWeek_Success() {
        // Arrange
        String teacherLastName = "Smith";
        String dayOfWeek = "Monday";
        List<DayLessonDto> expectedDayLessons = Collections.singletonList(
                new DayLessonDto("Math", "Mathematics", "09:00", "10:30"));

        when(lessonRepository.findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek))
                .thenReturn(expectedDayLessons);

        // Act
        List<DayLessonDto> result = lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);

        // Assert
        assertNotNull(result);
        assertEquals(expectedDayLessons, result);
        verify(lessonRepository, times(1)).findDayLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);
    }


    @Test
    void updateLesson_Success() {
        // Arrange
        int id = 1;
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(id);
        lessonEntity.setSubject("Math");

        LessonEntity existingLessonEntity = new LessonEntity();
        existingLessonEntity.setId(id);

        when(lessonRepository.findById(id))
                .thenReturn(Optional.of(existingLessonEntity));

        when(lessonRepository.save(any(LessonEntity.class)))
                .thenReturn(lessonEntity);

        // Act
        LessonEntity result = lessonService.updateLesson(id, lessonEntity);

        // Assert
        assertNotNull(result);
        assertEquals(lessonEntity, result);
        verify(lessonRepository, times(1)).findById(id);
        verify(lessonRepository, times(1)).save(any(LessonEntity.class));
    }

    @Test
    void updateLesson_NullLesson() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.updateLesson(1, null));
        verify(lessonRepository, never()).findById(anyInt());
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    @Test
    void updateLesson_LessonNotFound() {
        // Arrange
        int id = 1;
        LessonEntity lessonEntity = new LessonEntity();

        when(lessonRepository.findById(id))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> lessonService.updateLesson(id, lessonEntity));
        verify(lessonRepository, never()).save(any(LessonEntity.class));
    }

    @Test
    void convertToDto_Success() {
        // Arrange
        LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(1);
        lessonEntity.setStartTime("09:00");
        lessonEntity.setEndTime("10:30");
        lessonEntity.setSubject("Math");
        lessonEntity.setSubjectFull("Mathematics");
        lessonEntity.setDay("Monday");

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(101); // Assuming teacher's ID is 101
        lessonEntity.setTeacher(teacherEntity);

        // Создаем моки для репозиториев
        LessonRepository mockLessonRepository = Mockito.mock(LessonRepository.class);
        TeacherScheduleRepository mockTeacherScheduleRepository = Mockito.mock(TeacherScheduleRepository.class);

        // Создаем сервис и передаем ему моки
        LessonService lessonService = new LessonService(mockLessonRepository, mockTeacherScheduleRepository);

        // Act
        LessonDto lessonDto = lessonService.convertToDto(lessonEntity);

        // Assert
        assertEquals(1, lessonDto.getId());
        assertEquals("09:00", lessonDto.getStartTime());
        assertEquals("10:30", lessonDto.getEndTime());
        assertEquals("Math", lessonDto.getSubject());
        assertEquals("Mathematics", lessonDto.getSubjectFull());
        assertEquals("Monday", lessonDto.getDay());
        assertEquals(101, lessonDto.getTeacherId());
    }

    @Test
    void deleteLesson_Success() {
        // Arrange
        int id = 1;

        // Act
        lessonService.deleteLesson(id);

        // Assert
        verify(lessonRepository, times(1)).deleteById(id);
    }

    // Add more test cases for other methods as needed
}





