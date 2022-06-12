package com.jaethem8.jaethem8.service.personal

import com.jaethem8.jaethem8.model.personal.PersonalContent
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.repository.personal.PersonalContentRepository
import com.jaethem8.jaethem8.repository.personal.PersonalPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class PersonalService(
    private val personalPostRepository: PersonalPostRepository,
    private val personalContentRepository: PersonalContentRepository
) {
    fun getAllPersonalPost() : List<PersonalPost>{
        return personalPostRepository.findAll()
    }
    fun getPersonalPostByTitle(title:String) : PersonalPost? {
        return personalPostRepository.findByTitle(title)

    }
    fun deletePersonalPostByTitle(title:String){
        return personalPostRepository.deleteByTitle(title)
    }
}