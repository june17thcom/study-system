package com.example.jpa.service;

import com.example.jpa.entity.Study;
import com.example.jpa.mapper.ApplicationMapper;
import com.example.jpa.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    private static ApplicationMapper applicationMapper;
    @Autowired
    private static StudyMapper studyMapper;

    public static boolean applyToStudy(Long userId, Long studyId) {
        // 중복 지원 방지
        if (applicationMapper.hasApplied(userId, studyId) > 0) return false;

        // 모집 정원 체크
        Study study = studyMapper.selectById(studyId);
        int appliedCount = applicationMapper.countByStudyId(studyId);
        if (appliedCount >= study.getMaxParticipants()) {
            return false; // 정원 초과
        }

        applicationMapper.insertApplication(userId, studyId);
        return true;
    }
}
