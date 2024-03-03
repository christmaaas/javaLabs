package com.example.teachershedule.dao;

import com.example.teachershedule.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Integer>
{
}
