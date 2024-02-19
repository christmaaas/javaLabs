package com.example.TeacherShedule.Dto;

public class StudentGroupDto
{
    private String specialityName;
    private String specialityCode;
    private int numberOfStudents;
    private int name;
    private int educationDegree;

    // Getters
    public String getSpecialityName() {
        return specialityName;
    }

    public String getSpecialityCode() {
        return specialityCode;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getName() {
        return name;
    }

    public int getEducationDegree() {
        return educationDegree;
    }

    // Setters
    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setEducationDegree(int educationDegree) {
        this.educationDegree = educationDegree;
    }
}
