package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogImage
import java.sql.Date
import java.sql.Time
import javax.persistence.*

@Entity
@Table(name="blog_post")
data class BlogPost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    var id:Long=0,
    @Column(name="pub_date")
    var pubDate:Date?=null,

    @Column(name="title")
    var title:String?=null,
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    var blogContents:List<BlogContent> = mutableListOf(),
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    var blogImages:List<BlogImage> = mutableListOf(),
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    var blogCodes:List<BlogCode> = mutableListOf()


)