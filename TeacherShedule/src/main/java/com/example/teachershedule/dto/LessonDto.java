package com.example.teachershedule.dto;

public class LessonDto {
    private int id;
    private String subject;
    private String subjectFull;
    private String day;
    private String time;
    private int teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

}
