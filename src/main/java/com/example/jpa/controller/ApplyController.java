package com.example.jpa.controller;

import com.example.jpa.entity.Study;
import com.example.jpa.security.UserDetailsImpl;
import com.example.jpa.service.ApplicationService;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private UserService userService;

    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestParam Long studyId, Authentication auth) {
        Long userId = ((UserDetailsImpl) auth.getPrincipal()).getId();
        boolean success = ApplicationService.applyToStudy(userId, studyId);
        if (!success) {
            return ResponseEntity.badRequest().body("이미 신청했거나 정원이 초과되었습니다.");
        }
        return ResponseEntity.ok("신청 완료");
    }
}