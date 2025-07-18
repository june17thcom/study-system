package com.example.jpa.service;

import com.example.jpa.dto.StudyCreateDTO;
import com.example.jpa.entity.Study;
import com.example.jpa.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudyService {
    @Autowired
    private StudyMapper studyMapper;

    public void createStudy(StudyCreateDTO dto, Long creatorId) {
        Study study = new Study();
        study.setTitle(dto.getTitle());
        study.setDescription(dto.getDescription());
        study.setMaxParticipants(dto.getMaxParticipants());
        study.setDeadline(dto.getDeadline());
        study.setCreatorId(creatorId);
        studyMapper.insertStudy(study);
    }

    public List<Study> getAllStudies(int offset, int limit) {
        return studyMapper.selectAll(offset, limit);
    }

    public List<Study> searchStudies(String keyword) {
        return studyMapper.searchStudies(keyword);
    }

    public Study getStudyById(Long id) {
        return studyMapper.selectById(id);
    }

    public List<Study> getMyCreatedStudies(Long userId) {
        return studyMapper.selectCreatedByUser(userId);
    }

    public List<Study> getMyAppliedStudies(Long userId) {
        return studyMapper.selectAppliedByUser(userId);
    }

}