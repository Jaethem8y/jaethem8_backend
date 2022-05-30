package com.jaethem8.jaethem8.model.study

import javax.persistence.*

@Entity
@Table(name="study_content")
data class StudyContent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long,
    @Column(name="location")
    val location:Int,
    @Column(name="content")
    val content:String,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="study_post_id")
    val studyPost: StudyPost,
)