package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDtoTest {

    @Test
    void testSettersAndGetters() {
        EmployeeDto employeeDto = new EmployeeDto();
        int id = 1;
        String firstName = "John";
        String middleName = "Doe";
        String lastName = "Smith";
        String photoLink = "http://example.com/photo.jpg";
        String degree = "PhD";
        String degreeAbbrev = "Dr.";
        String rank = "Professor";
        String email = "john.smith@example.com";
        String urlId = "john.smith";
        String calendarId = "john.smith@example.com";

        employeeDto.setId(id);
        employeeDto.setFirstName(firstName);
        employeeDto.setMiddleName(middleName);
        employeeDto.setLastName(lastName);
        employeeDto.setPhotoLink(photoLink);
        employeeDto.setDegree(degree);
        employeeDto.setDegreeAbbrev(degreeAbbrev);
        employeeDto.setRank(rank);
        employeeDto.setEmail(email);
        employeeDto.setUrlId(urlId);
        employeeDto.setCalendarId(calendarId);

        assertEquals(id, employeeDto.getId());
        assertEquals(firstName, employeeDto.getFirstName());
        assertEquals(middleName, employeeDto.getMiddleName());
        assertEquals(lastName, employeeDto.getLastName());
        assertEquals(photoLink, employeeDto.getPhotoLink());
        assertEquals(degree, employeeDto.getDegree());
        assertEquals(degreeAbbrev, employeeDto.getDegreeAbbrev());
        assertEquals(rank, employeeDto.getRank());
        assertEquals(email, employeeDto.getEmail());
        assertEquals(urlId, employeeDto.getUrlId());
        assertEquals(calendarId, employeeDto.getCalendarId());
    }
}
