package com.jaethem8.jaethem8.model.study

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
        val id:Long,
        @Column(name="pub_date")
        val pubDate: Date,
        @Column(name="pub_time")
        val pupTime: Time,
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
        val studyContents:List<StudyContent>,
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
        val studyImages:List<StudyImage>
        )