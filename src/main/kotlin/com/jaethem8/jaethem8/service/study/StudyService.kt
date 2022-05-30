package com.jaethem8.jaethem8.service.study

import com.jaethem8.jaethem8.repository.study.StudyContentRepository
import com.jaethem8.jaethem8.repository.study.StudyImageRepository
import com.jaethem8.jaethem8.repository.study.StudyPostRepository
import org.springframework.stereotype.Service

@Service
class StudyService(
    private val studyPostRepository: StudyPostRepository,
    private val studyImageRepository: StudyImageRepository,
    private val studyContentRepository: StudyContentRepository
) {
}