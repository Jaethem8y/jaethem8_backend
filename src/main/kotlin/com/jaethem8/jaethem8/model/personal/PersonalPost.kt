package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name="personal_post")
data class PersonalPost(
    @Id
    @Column(name="title")
    var title:String?=null,
    @Column(name="pub_date")
    var pubDate:Date?=null,
    @JsonManagedReference
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    val personalContents:List<PersonalContent> = mutableListOf(),
)