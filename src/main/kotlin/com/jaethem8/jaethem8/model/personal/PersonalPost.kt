package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogImage
import java.sql.Date
import java.sql.Time
import javax.persistence.*

@Entity
@Table(name="personal_post")
data class PersonalPost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long=0,
    @Column(name="pub_date")
    val pubDate: Date?,

    @Column(name="title")
    val title:String,
    @JsonManagedReference
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    val personalContents:List<PersonalContent> = mutableListOf(),
    @JsonManagedReference
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    val personalImages:List<PersonalImage> = mutableListOf(),
    @JsonManagedReference
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    val personalCodes:List<PersonalCode> = mutableListOf()
)