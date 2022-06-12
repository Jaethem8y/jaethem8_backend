package com.jaethem8.jaethem8.repository.security

import com.jaethem8.jaethem8.model.security.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository: JpaRepository<Role, Long> {
    fun findByName(name:String):Role
}