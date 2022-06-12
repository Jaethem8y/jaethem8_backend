package com.jaethem8.jaethem8.model.security

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class User(
    @Id
    @Column(name="id")
    val id:Long,
    val name:String,
    val username:String,
    val password:String,
    @ManyToMany(fetch=FetchType.EAGER)
    val role:Collection<Role> = mutableListOf(),
)