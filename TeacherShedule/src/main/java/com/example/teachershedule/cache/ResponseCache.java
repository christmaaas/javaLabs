package com.example.teachershedule.cache;

import com.example.teachershedule.dto.LessonDto;
import com.example.teachershedule.dto.ScheduleResponseDto;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ResponseCache
{
    private final Map<String, ScheduleResponseDto> scheduleResponseDtoMap = new ConcurrentHashMap<>();
    private final Map<Integer, LessonDto> lessonResponseDtoMap = new ConcurrentHashMap<>();

    public void saveScheduleResponse(String key, ScheduleResponseDto value) {
        scheduleResponseDtoMap.put(key, value);
    }

    public void saveLessonResponse(int key, LessonDto value) {
        lessonResponseDtoMap.put(key, value);
    }

    public ScheduleResponseDto getScheduleResponse(String key) {
        return scheduleResponseDtoMap.get(key);
    }

    public LessonDto getLessonResponse(int key) {
        return lessonResponseDtoMap.get(key);
    }

    public void removeScheduleResponse(String key) {
        scheduleResponseDtoMap.remove(key);
    }

    public void removeLessonResponse(int key) {
        lessonResponseDtoMap.remove(key);
    }

    public void clearScheduleResponses() {
        scheduleResponseDtoMap.clear();
    }

    public void clearLessonResponses() {
        lessonResponseDtoMap.clear();
    }

    public int getSizeOfScheduleResponses() {
        return scheduleResponseDtoMap.size();
    }

    public int getSizeOfLessonResponses() {
        return lessonResponseDtoMap.size();
    }
}

