package com.example.teachershedule.dao;

import com.example.teachershedule.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer>
{
    GroupEntity findByName(String name);
}
