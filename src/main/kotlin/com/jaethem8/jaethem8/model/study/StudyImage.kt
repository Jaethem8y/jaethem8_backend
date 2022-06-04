package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="study_image")
class StudyImage (
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
    @JoinColumn(name="study_post_id")
    var studyPost: StudyPost?,
)