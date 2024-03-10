package com.example.teachershedule.controller;

import com.example.teachershedule.cache.ResponseCache;
import com.example.teachershedule.dto.DayLessonDto;
import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.entity.LessonEntity;
import com.example.teachershedule.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;
    private final ResponseCache responseCache;

    private static final String SUCCESS = "success";

    @Autowired
    public LessonController(LessonService lessonService,
                            ResponseCache responseCache) {
        this.lessonService = lessonService;
        this.responseCache = responseCache;
    }

    @GetMapping("/get/{id}")
    public LessonDto getLessonById(@PathVariable int id) {
        LessonDto lessonDto = responseCache.getLessonResponse(id);

        if (lessonDto != null) {
            return lessonDto;
        } else {
            lessonDto = lessonService.getLessonById(id);
            responseCache.saveLessonResponse(id, lessonDto);
            return lessonDto;
        }
    }

    @GetMapping("/useful")
    public List<DayLessonDto> getLessonsByTeacherLastNameAndDayOfWeek(@RequestParam("teacherLastName") String teacherLastName, @RequestParam("dayOfWeek") String dayOfWeek) {
        return lessonService.getLessonsByTeacherLastNameAndDayOfWeek(teacherLastName, dayOfWeek);
    }

    @PostMapping("/add/{teacher}")
    public ResponseEntity<String> addLesson(@RequestBody LessonEntity lessonEntity,
                                            @PathVariable("teacher") String teacher) {
        if (lessonEntity == null) {
            return ResponseEntity.badRequest().body("error");
        }
        try {
            lessonService.addLesson(lessonEntity, teacher);

            return ResponseEntity.ok(SUCCESS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLesson(@PathVariable("id") int id,
                                               @RequestBody LessonEntity lessonEntity) {
        if (lessonEntity == null) {
            return ResponseEntity.badRequest().body("error");
        }

        try {
            lessonService.updateLesson(id, lessonEntity);
            return ResponseEntity.ok(SUCCESS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable int id) {
        try {
            lessonService.deleteLesson(id);
            return ResponseEntity.ok(SUCCESS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
