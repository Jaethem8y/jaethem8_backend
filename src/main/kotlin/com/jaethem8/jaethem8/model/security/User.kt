package com.jaethem8.jaethem8.model.security

import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    var id:Long?,
    var name:String,
    var username:String,
    var password:String,
    @ManyToMany(fetch=FetchType.EAGER)
    var role:List<Role> = mutableListOf(),
)