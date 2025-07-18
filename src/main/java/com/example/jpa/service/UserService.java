package com.example.jpa.service;
import com.example.jpa.dto.UserRegisterDTO;
import com.example.jpa.entity.Study;
import com.example.jpa.entity.User;
import com.example.jpa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired private PasswordEncoder encoder;

    public void register(UserRegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setNickname(dto.getNickname());
        userMapper.insertUser(user);
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public List<Study> getMyCreatedStudies(Long userId) {
        return userMapper.getCreatedStudies(userId);
    }

    public List<Study> getMyAppliedStudies(Long userId) {
        return userMapper.getAppliedStudies(userId);
    }
}