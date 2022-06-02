package com.jaethem8.jaethem8.service.personal

import com.jaethem8.jaethem8.model.personal.PersonalContent
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.repository.personal.PersonalContentRepository
import com.jaethem8.jaethem8.repository.personal.PersonalImageRepository
import com.jaethem8.jaethem8.repository.personal.PersonalPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonalService(
    private val personalPostRepository: PersonalPostRepository,
    private val personalImageRepository: PersonalImageRepository,
    private val personalContentRepository: PersonalContentRepository
) {
    fun getAllPersonalPost() : List<PersonalPost>{
        return personalPostRepository.findAll()
    }
    fun getPersonalPostById(id:Long) : PersonalPost? {
        return personalPostRepository.findByIdOrNull(id)

    }
    fun deletePersonalPostById(id:Long){
        return personalPostRepository.deleteById(id)
    }
    fun addPersonalPost(personalPost: PersonalPost):PersonalPost{
        personalPost.personalCode.forEach{it.personalPost = personalPost}
        personalPost.personalContents.forEach{it.personalPost = personalPost}
        personalPost.personalImages.forEach{it.personalPost = personalPost}
        return personalPostRepository.save(personalPost)
    }
    fun updatePersonalPost(personalPost: PersonalPost):PersonalPost{
        personalPostRepository.deleteById(personalPost.id)
        personalPost.personalCode.forEach{it.personalPost = personalPost}
        personalPost.personalContents.forEach{it.personalPost = personalPost}
        personalPost.personalImages.forEach{it.personalPost = personalPost}
        return personalPostRepository.save(personalPost)
    }
}