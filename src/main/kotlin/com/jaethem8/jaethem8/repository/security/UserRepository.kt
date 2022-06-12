package com.jaethem8.jaethem8.repository.security

import com.jaethem8.jaethem8.model.security.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username:String):User
}