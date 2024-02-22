package com.example.teachershedule.dto;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ScheduleResponceDto
{
    private EmployeeDto employeeDto;
    private Map<String, List<ScheduleDto>> schedules;
    private List<ExamDto> exams;
    private String startDate;
    private String endDate;
    private String startExamsDate;
    private String endExamsDate;

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public Map<String, List<ScheduleDto>> getSchedules() {
        return schedules;
    }

    public List<ExamDto> getExams() {
        return exams;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartExamsDate() {
        return startExamsDate;
    }

    public String getEndExamsDate() {
        return endExamsDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStartExamsDate(String startExamsDate) {
        this.startExamsDate = startExamsDate;
    }

    public void setEndExamsDate(String endExamsDate) {
        this.endExamsDate = endExamsDate;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public void setSchedules(Map<String, List<ScheduleDto>> schedules) {
        this.schedules = schedules;
    }

    public void setExams(List<ExamDto> exams) {
        this.exams = exams;
    }
}
