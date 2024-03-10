package com.example.teachershedule.cache;

import com.example.teachershedule.dto.LessonDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LessonCache
{
    private final Map<Integer, LessonDto> lessonResponseDtoMap = new ConcurrentHashMap<>();

    public void saveLessonResponse(int key, LessonDto value) {
        lessonResponseDtoMap.put(key, value);
    }

    public LessonDto getLessonResponse(int key) {
        return lessonResponseDtoMap.get(key);
    }

    public void removeLessonResponse(int key) {
        lessonResponseDtoMap.remove(key);
    }

    public void clearLessonResponses() {
        lessonResponseDtoMap.clear();
    }

    public int getSizeOfLessonResponses() {
        return lessonResponseDtoMap.size();
    }
}
