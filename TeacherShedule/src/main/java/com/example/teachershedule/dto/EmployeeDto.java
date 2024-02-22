package com.example.teachershedule.dto;

public class EmployeeDto
{
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String photoLink;
    private String degree;
    private String degreeAbbrev;
    private String rank;
    private String email;
    private String urlId;
    private String calendarId;

    public int getId() { return this.id; }

    public String getFirstName() { return this.firstName; }

    public String getMiddleName() { return this.middleName; }

    public String getLastName() { return this.lastName; }

    public String getPhotoLink() { return this.photoLink; }

    public String getDegree() { return this.degree; }

    public String getDegreeAbbrev() { return this.degreeAbbrev; }

    public String getRank() { return this.rank; }

    public String getEmail() { return this.email; }

    public String getUrlId() { return this.urlId; }

    public String getCalendarId() { return this.calendarId; }

    public void setId(int id) { this.id = id; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setPhotoLink(String photoLink) { this.photoLink = photoLink; }

    public void setDegree(String degree) { this.degree = degree; }

    public void setDegreeAbbrev(String degreeAbbrev) { this.degreeAbbrev = degreeAbbrev; }

    public void setRank(String rank) { this.rank = rank; }

    public void setEmail(String email) { this.email = email; }

    public void setUrlId(String urlId) { this.urlId = urlId; }

    public void setCalendarId(String calendarId) { this.calendarId = calendarId; }


}
