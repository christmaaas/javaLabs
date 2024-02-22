package com.example.teachershedule.dao;

import com.example.teachershedule.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherScheduleRepository extends JpaRepository<TeacherEntity, Integer>
{
}
