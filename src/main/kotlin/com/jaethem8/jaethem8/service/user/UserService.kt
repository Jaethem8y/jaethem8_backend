package com.jaethem8.jaethem8.service.user

import com.jaethem8.jaethem8.model.user.User
import com.jaethem8.jaethem8.repository.user.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) : UserDetailsService {
    fun save(user: User): User? {
        user.password = passwordEncoder!!.encode(user.password)
        return userRepository.save(user)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("Invalid Username or Password")
        var authorities = mutableListOf<SimpleGrantedAuthority>()
        authorities += SimpleGrantedAuthority(user.role)
        return org.springframework.security.core.userdetails.User(
            user.username, user.password, authorities
        )
    }

    fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }
}