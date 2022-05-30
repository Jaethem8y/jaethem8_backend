package com.jaethem8.jaethem8.model.personal

import javax.persistence.*

@Entity
@Table(name="personal_content")
data class PersonalContent (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long,
    @Column(name="location")
    val location:Int,
    @Column(name="content")
    val content:String,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="personal_post_id")
    val personalPost: PersonalPost,
)