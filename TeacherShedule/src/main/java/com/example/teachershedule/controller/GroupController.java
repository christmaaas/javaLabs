package com.example.teachershedule.controller;

import com.example.teachershedule.dto.GroupDto;
import com.example.teachershedule.entity.GroupEntity;
import com.example.teachershedule.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";


    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/add/{group}")
    public ResponseEntity<String> addGroup(@RequestBody GroupEntity groupEntity,
                                            @PathVariable("group") String group) {
        if (groupEntity == null) {
            return ResponseEntity.badRequest().body(ERROR);
        }
        try {
            groupService.addGroup(groupEntity, group);

            return ResponseEntity.ok(SUCCESS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR + ": " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public GroupDto getGroupById(@PathVariable int id) {

        return groupService.getGroupById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLesson(@PathVariable("id") int id,
                                               @RequestBody GroupEntity groupEntity) {
        if (groupEntity == null) {
            return ResponseEntity.badRequest().body(ERROR);
        }

        try {
            groupService.updateGroup(id, groupEntity);
            return ResponseEntity.ok(SUCCESS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERROR + " " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable int id) {
        try {
            groupService.deleteGroup(id);
            return ResponseEntity.ok(SUCCESS);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
