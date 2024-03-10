package com.example.teachershedule.dto;

public class DayLessonDto
{
    private String subject;
    private String subjectFull;
    private String startTime;
    private String endTime;

    public DayLessonDto(String subject, String subjectFull, String startTime, String endTime)
    {
        this.subject = subject;
        this.subjectFull = subjectFull;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectFull() {
        return subjectFull;
    }

    public void setSubjectFull(String subjectFull) {
        this.subjectFull = subjectFull;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
