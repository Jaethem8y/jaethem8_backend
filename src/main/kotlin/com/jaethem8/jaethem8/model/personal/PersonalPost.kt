package com.jaethem8.jaethem8.model.personal

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
    val id:Long,
    @Column(name="pub_date")
    val pubDate: Date,
    @Column(name="pub_time")
    val pupTime: Time,
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    val personalContents:List<PersonalContent>,
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    val personalImages:List<PersonalImage>
)