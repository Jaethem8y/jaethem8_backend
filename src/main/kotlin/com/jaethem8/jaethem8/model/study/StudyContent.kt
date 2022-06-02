package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="study_content")
data class StudyContent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long=0,
    @Column(name="location")
    val location:Int=0,
    @Column(name = "content", length = 16777215, columnDefinition = "mediumtext")
    val content:String="",
    @ManyToOne(cascade = [CascadeType.ALL])
    @JsonBackReference
    @JoinColumn(name="study_post_id")
    var studyPost: StudyPost?,
)