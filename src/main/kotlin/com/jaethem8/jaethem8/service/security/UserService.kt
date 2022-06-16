package com.jaethem8.jaethem8.service.security

import com.jaethem8.jaethem8.model.security.Role
import com.jaethem8.jaethem8.model.security.User
import com.jaethem8.jaethem8.repository.security.RoleRepository
import com.jaethem8.jaethem8.repository.security.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder:PasswordEncoder
):UserDetailsService {
    fun saveUser(user:User): User{
        user.password = passwordEncoder.encode(user.password)
        return userRepository.save(user)
    }
    fun saveRole(role: Role):Role{
        return roleRepository.save(role)
    }
    fun addRoleToUser(username:String,roleName:String): User {
        val user:User = userRepository.findByUsername(username)
        val role:Role = roleRepository.findByName(roleName)
        user.role += role
        return userRepository.save(user)
    }
    fun getUser(username:String):User{
        print(userRepository.findByUsername(username).name)
        return userRepository.findByUsername(username)
    }
    fun getUsers():List<User>{
        return userRepository.findAll()
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user:User = userRepository.findByUsername(username)
        var authorities:List<SimpleGrantedAuthority> = mutableListOf()

        user.role.forEach{
            authorities += SimpleGrantedAuthority(it.name)
        }

        return org.springframework.security.core.userdetails.User(user.username,user.password,authorities);
    }
}