package com.jaethem8.jaethem8.model.blog

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
    val id:Long,
    @Column(name="pub_date")
    val pubDate:Date,
    @Column(name="pub_time")
    val pupTime:Time,
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    val blogContents:List<BlogContent>,
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    val blogImages:List<BlogImage>

)