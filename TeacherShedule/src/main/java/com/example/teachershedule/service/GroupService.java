package com.example.teachershedule.service;

import com.example.teachershedule.dao.GroupRepository;
import com.example.teachershedule.dto.GroupDto;
import com.example.teachershedule.entity.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupEntity addGroup(GroupEntity groupEntity, String name) {
        if (groupEntity == null) {
            throw new IllegalArgumentException("error");
        }

        GroupEntity groupEntity2 = groupRepository.findByName(name);

        if(groupEntity2 == null) {

            return groupRepository.save(groupEntity);
        } else {
            throw new IllegalArgumentException("error");
        }
    }

    public GroupDto getGroupById(int id) {

        Optional<GroupEntity> auditoryOptional = groupRepository.findById(id);

        if (auditoryOptional.isPresent()) {
            return convertToDto(auditoryOptional.get());
        } else {
            return null;
        }
    }

    public GroupEntity updateGroup(int id, GroupEntity groupEntity) {
        if (groupEntity == null) {
            throw new IllegalArgumentException("error");
        }

        Optional<GroupEntity> existingEntityOptional = groupRepository.findById(id);

        if (existingEntityOptional.isEmpty()) {
            throw new IllegalArgumentException("id=" + id + " not found");
        }

        GroupEntity existingEntity = existingEntityOptional.get();

        existingEntity.setName(groupEntity.getName());
        existingEntity.setSpecialityCode(groupEntity.getSpecialityCode());
        existingEntity.setSpecialityName(groupEntity.getSpecialityName());
        existingEntity.setNumberOfStudents(groupEntity.getNumberOfStudents());
        existingEntity.setEducationDegree(groupEntity.getEducationDegree());

        return groupRepository.save(existingEntity);

    }

    public void deleteGroup(int id) {
        groupRepository.deleteById(id);
    }

    private GroupDto convertToDto(GroupEntity groupEntity) {

        GroupDto groupDto = new GroupDto();
        groupDto.setName(groupEntity.getName());
        groupDto.setSpecialityCode(groupEntity.getSpecialityCode());
        groupDto.setSpecialityName(groupEntity.getSpecialityName());
        groupDto.setNumberOfStudents(groupEntity.getNumberOfStudents());

        return groupDto;
    }
}
