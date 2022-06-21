package com.jaethem8.jaethem8.security

import com.jaethem8.jaethem8.service.user.UserService
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val auth = DaoAuthenticationProvider()
        auth.setUserDetailsService(userService)
        auth.setPasswordEncoder(passwordEncoder)
        return auth
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers(
            "/registration", "/js/**",
            "/css/**", "/API/**"
        ).permitAll()
            .and()
            .authorizeRequests().anyRequest()
            .authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
            .invalidateHttpSession(true).clearAuthentication(true)
            .logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
            .permitAll()
    }
}