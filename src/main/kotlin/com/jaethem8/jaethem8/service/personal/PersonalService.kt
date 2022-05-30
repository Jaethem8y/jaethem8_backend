package com.jaethem8.jaethem8.service.personal

import com.jaethem8.jaethem8.repository.personal.PersonalContentRepository
import com.jaethem8.jaethem8.repository.personal.PersonalImageRepository
import com.jaethem8.jaethem8.repository.personal.PersonalPostRepository
import org.springframework.stereotype.Service

@Service
class PersonalService(
    private val personalPostRepository: PersonalPostRepository,
    private val personalImageRepository: PersonalImageRepository,
    private val personalContentRepository: PersonalContentRepository
) {
}