package com.jaethem8.jaethem8

import com.jaethem8.jaethem8.model.security.Role
import com.jaethem8.jaethem8.model.security.User
import com.jaethem8.jaethem8.service.security.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class Jaethem8Application{
	@Bean
	fun passwordEncoder():PasswordEncoder{
		return BCryptPasswordEncoder()
	}
}

fun main(args: Array<String>) {
	runApplication<Jaethem8Application>(*args)
}


