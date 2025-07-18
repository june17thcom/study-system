package com.example.jpa.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import com.example.jpa.entity.Application;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationMapper {
    void insertApplication(Application application);
    boolean existsByUserIdAndStudyId(Long userId, Long studyId);
    int countByStudyId(Long studyId);
    void insertApplication(@Param("userId") Long userId, @Param("studyId") Long studyId);
    int hasApplied(@Param("userId") Long userId, @Param("studyId") Long studyId);
}

