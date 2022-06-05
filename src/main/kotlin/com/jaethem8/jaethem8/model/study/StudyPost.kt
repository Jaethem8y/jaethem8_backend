package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.study.StudyContent
import com.jaethem8.jaethem8.model.study.StudyImage
import java.sql.Date
import java.sql.Time
import javax.persistence.*

@Entity
@Table(name="study_post")
class StudyPost (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        val id:Long=0,
        @Column(name="pub_date")
        val pubDate: Date?,

        @Column(name="title")
        val title:String,
        @JsonManagedReference
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
        val studyContents:List<StudyContent> = mutableListOf(),
        @JsonManagedReference
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
        val studyImages:List<StudyImage> = mutableListOf(),
        @JsonBackReference
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
        val studyCodes:List<StudyCode> = mutableListOf(),
        )