package com.jaethem8.jaethem8.model.personal

import com.jaethem8.jaethem8.model.study.StudyPost
import javax.persistence.*

@Entity
@Table(name="personal_image")
data class PersonalImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long,
    @Column(name="location")
    val location:Int,
    @Column(name="image")
    val image:String,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="personal_post_id")
    val personalPost: PersonalPost,
)