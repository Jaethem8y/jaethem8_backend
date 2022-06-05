package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name="blog_post")
data class BlogPost(
    @Id
    @Column(name="title")
    var title:String?=null,
    @Column(name="pub_date")
    var pubDate:Date?=null,
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    var blogContents:List<BlogContent> = mutableListOf(),
)