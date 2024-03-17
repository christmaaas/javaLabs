package com.example.teachershedule.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentGroupDtoTest {

    @Test
    void testSettersAndGetters() {
        StudentGroupDto studentGroupDto = new StudentGroupDto();
        String specialityName = "Computer Science";
        String specialityCode = "CS";
        int numberOfStudents = 30;
        int name = 101;
        int educationDegree = 1;

        studentGroupDto.setSpecialityName(specialityName);
        studentGroupDto.setSpecialityCode(specialityCode);
        studentGroupDto.setNumberOfStudents(numberOfStudents);
        studentGroupDto.setName(name);
        studentGroupDto.setEducationDegree(educationDegree);

        assertEquals(specialityName, studentGroupDto.getSpecialityName());
        assertEquals(specialityCode, studentGroupDto.getSpecialityCode());
        assertEquals(numberOfStudents, studentGroupDto.getNumberOfStudents());
        assertEquals(name, studentGroupDto.getName());
        assertEquals(educationDegree, studentGroupDto.getEducationDegree());
    }
}
