package com.jaethem8.jaethem8.model.blog

import javax.persistence.*

@Entity
@Table(name="blog_content")
data class BlogContent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long,
    @Column(name="location")
    val location:Int,
    @Column(name="content")
    val content:String,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name="blog_post_id")
    val blogPost: BlogPost,
)