package com.example.jpa.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.example.jpa.entity.Study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudyMapper {
    void insertStudy(Study study);
    Study selectById(Long id);
    List<Study> selectAll(@Param("offset") int offset, @Param("limit") int limit);
    List<Study> searchStudies(@Param("keyword") String keyword);
    List<Study> selectCreatedByUser(@Param("userId") Long userId);
    List<Study> selectAppliedByUser(@Param("userId") Long userId);
}
