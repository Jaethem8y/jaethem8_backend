package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name="study_post")
class StudyPost(
        @Id
        @Column(name="title")
        var title:String?=null,
        @Column(name="pub_date")
        var pubDate:Date?=null,
        @JsonManagedReference
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
        val studyContents:List<StudyContent> = mutableListOf(),
)