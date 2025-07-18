package com.example.jpa.controller;

import com.example.jpa.entity.Study;
import com.example.jpa.security.UserDetailsImpl;
import com.example.jpa.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mypage")
public class MyStudyController {

    @Autowired
    private StudyService studyService;

    @GetMapping("/created")
    public ResponseEntity<List<Study>> getCreated(Authentication auth) {
        Long userId = ((UserDetailsImpl) auth.getPrincipal()).getId();
        return ResponseEntity.ok(studyService.getMyCreatedStudies(userId));
    }

    @GetMapping("/applied")
    public ResponseEntity<List<Study>> getApplied(Authentication auth) {
        Long userId = ((UserDetailsImpl) auth.getPrincipal()).getId();
        return ResponseEntity.ok(studyService.getMyAppliedStudies(userId));
    }
}