package com.example.TeacherShedule.Repository;

import com.example.TeacherShedule.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherScheduleRepository extends JpaRepository<Teacher, Integer>
{
}
