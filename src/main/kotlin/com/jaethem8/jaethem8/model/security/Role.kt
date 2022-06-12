package com.jaethem8.jaethem8.model.security

import javax.persistence.*

@Entity
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    var id:Long?,
    val name:String,
)