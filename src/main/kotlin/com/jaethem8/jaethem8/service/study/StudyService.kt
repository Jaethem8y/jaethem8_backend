package com.jaethem8.jaethem8.service.study

import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.repository.study.StudyContentRepository
import com.jaethem8.jaethem8.repository.study.StudyImageRepository
import com.jaethem8.jaethem8.repository.study.StudyPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudyService(
    private val studyPostRepository: StudyPostRepository,
    private val studyImageRepository: StudyImageRepository,
    private val studyContentRepository: StudyContentRepository
) {
    fun getAllStudyPost():List<StudyPost>{
        return studyPostRepository.findAll()
    }
    fun getStudyPostById(id:Long): StudyPost? {
        return studyPostRepository.findByIdOrNull(id)
    }
    fun deleteStudyPostById(id:Long){
        return studyPostRepository.deleteById(id)
    }
    fun addStudyPost(studyPost: StudyPost): StudyPost{
        studyPost.studyCodes.forEach{it.studyPost = studyPost}
        studyPost.studyContents.forEach{it.studyPost = studyPost}
        studyPost.studyImages.forEach{it.studyPost = studyPost}
        return studyPostRepository.save(studyPost)
    }
    fun updateStudyPost(studyPost: StudyPost):StudyPost{
        studyPostRepository.deleteById(studyPost.id)
        studyPost.studyCodes.forEach{it.studyPost = studyPost}
        studyPost.studyContents.forEach{it.studyPost = studyPost}
        studyPost.studyImages.forEach{it.studyPost = studyPost}
        return studyPostRepository.save(studyPost)
    }

}