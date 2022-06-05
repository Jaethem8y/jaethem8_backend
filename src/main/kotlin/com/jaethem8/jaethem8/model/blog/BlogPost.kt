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
    val id:Long=0,
    @Column(name="pub_date")
    val pubDate:Date?,
    @Column(name="pub_time")
    val pubTime:Time?,
    @Column(name="title")
    val title:String?,
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    val blogContents:List<BlogContent> = mutableListOf(),
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    val blogImages:List<BlogImage> = mutableListOf(),
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    val blogCode:List<BlogCode> = mutableListOf()


)