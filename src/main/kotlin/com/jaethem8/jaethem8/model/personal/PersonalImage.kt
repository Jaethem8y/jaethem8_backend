package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.study.StudyPost
import javax.persistence.*

@Entity
@Table(name="personal_image")
data class PersonalImage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long=0,
    @Column(name="location")
    val location:Int=0,
    @Column(name="image")
    var image:ByteArray?,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JsonBackReference
    @JoinColumn(name="personal_post_id")
    var personalPost: PersonalPost?,
)