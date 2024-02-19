package com.example.TeacherShedule.Dto;

import java.util.List;

public class ScheduleDto
{
    private List<String> auditories;
    private String endLessonTime;
    private String lessonTypeAbbrev;
    private String note;
    private int numSubgroup;
    private String startLessonTime;
    private List<StudentGroupDto> studentGroups;
    private String subject;
    private String subjectFullName;
    private List<Integer> weekNumber;
    private String dateLesson;
    private String startLessonDate;
    private String endLessonDate;
    private boolean announcement;
    private boolean split;


    public List<String> getAuditories() {
        return auditories;
    }

    public String getEndLessonTime() {
        return endLessonTime;
    }

    public String getLessonTypeAbbrev() {
        return lessonTypeAbbrev;
    }

    public String getNote() {
        return note;
    }

    public int getNumSubgroup() {
        return numSubgroup;
    }

    public String getStartLessonTime() {
        return startLessonTime;
    }

    public List<StudentGroupDto> getStudentGroups() {
        return studentGroups;
    }

    public String getSubject() {
        return subject;
    }

    public String getSubjectFullName() {
        return subjectFullName;
    }

    public List<Integer> getWeekNumber() {
        return weekNumber;
    }

    public String getDateLesson() {
        return dateLesson;
    }

    public String getStartLessonDate() {
        return startLessonDate;
    }

    public String getEndLessonDate() {
        return endLessonDate;
    }

    public boolean isAnnouncement() {
        return announcement;
    }

    public boolean isSplit() {
        return split;
    }

    public void setAuditories(List<String> auditories) {
        this.auditories = auditories;
    }

    public void setEndLessonTime(String endLessonTime) {
        this.endLessonTime = endLessonTime;
    }

    public void setLessonTypeAbbrev(String lessonTypeAbbrev) {
        this.lessonTypeAbbrev = lessonTypeAbbrev;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNumSubgroup(int numSubgroup) {
        this.numSubgroup = numSubgroup;
    }

    public void setStartLessonTime(String startLessonTime) {
        this.startLessonTime = startLessonTime;
    }

    public void setStudentGroups(List<StudentGroupDto> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSubjectFullName(String subjectFullName) {
        this.subjectFullName = subjectFullName;
    }

    public void setWeekNumber(List<Integer> weekNumber) {
        this.weekNumber = weekNumber;
    }

    public void setDateLesson(String dateLesson) {
        this.dateLesson = dateLesson;
    }

    public void setStartLessonDate(String startLessonDate) {
        this.startLessonDate = startLessonDate;
    }

    public void setEndLessonDate(String endLessonDate) {
        this.endLessonDate = endLessonDate;
    }

    public void setAnnouncement(boolean announcement) {
        this.announcement = announcement;
    }

    public void setSplit(boolean split) {
        this.split = split;
    }
}
