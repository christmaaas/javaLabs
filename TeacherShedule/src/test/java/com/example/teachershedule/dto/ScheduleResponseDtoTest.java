package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleResponseDtoTest {

    @Test
    public void testSetters() {
        // Arrange
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto();
        EmployeeDto employeeDto = new EmployeeDto();
        Map<String, List<ScheduleDto>> schedules = new HashMap<>();
        List<ExamDto> exams = new ArrayList<>();
        String startDate = "2024-03-20";
        String endDate = "2024-06-30";
        String startExamsDate = "2024-06-01";
        String endExamsDate = "2024-06-15";

        // Act
        scheduleResponseDto.setEmployeeDto(employeeDto);
        scheduleResponseDto.setSchedules(schedules);
        scheduleResponseDto.setExams(exams);
        scheduleResponseDto.setStartDate(startDate);
        scheduleResponseDto.setEndDate(endDate);
        scheduleResponseDto.setStartExamsDate(startExamsDate);
        scheduleResponseDto.setEndExamsDate(endExamsDate);

        // Assert
        assertEquals(employeeDto, scheduleResponseDto.getEmployeeDto());
        assertEquals(schedules, scheduleResponseDto.getSchedules());
        assertEquals(exams, scheduleResponseDto.getExams());
        assertEquals(startDate, scheduleResponseDto.getStartDate());
        assertEquals(endDate, scheduleResponseDto.getEndDate());
        assertEquals(startExamsDate, scheduleResponseDto.getStartExamsDate());
        assertEquals(endExamsDate, scheduleResponseDto.getEndExamsDate());
    }
}
