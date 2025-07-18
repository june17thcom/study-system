package com.example.jpa.mapper;

import com.example.jpa.entity.Study;
import com.example.jpa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByUsername(String username);
    User findById(Long id);
    List<User> findAll();
    List<Study> getCreatedStudies(@Param("userId") Long userId);
    List<Study> getAppliedStudies(@Param("userId") Long userId);
}

