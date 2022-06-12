package com.jaethem8.jaethem8.service.study

import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.repository.study.StudyContentRepository
import com.jaethem8.jaethem8.repository.study.StudyPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class StudyService(
    private val studyPostRepository: StudyPostRepository,
    private val studyContentRepository: StudyContentRepository
) {
    fun getAllStudyPost():List<StudyPost>{
        return studyPostRepository.findAll()
    }
    fun getStudyPostByTitle(title:String): StudyPost? {
        return studyPostRepository.findByTitle(title)
    }
    fun deleteStudyPostByTitle(title:String){
        return studyPostRepository.deleteByTitle(title)
    }
}