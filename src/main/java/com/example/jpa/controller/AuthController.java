package com.example.jpa.controller;

import com.example.jpa.dto.UserRegisterDTO;
import com.example.jpa.entity.User;
import com.example.jpa.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDTO dto) {
        userService.register(dto);
        return ResponseEntity.ok("Registered");
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMe(Authentication auth) {
        User user = userService.findByUsername(auth.getName());
        return ResponseEntity.ok(user);
    }
}
