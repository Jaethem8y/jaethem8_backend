package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="blog_code")
class BlogCode (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id:Long=0,
    @Column(name="location")
    val location:Int=0,
    @Column(name = "code", length = 16777215, columnDefinition = "mediumtext")
    val code:String="",
    @ManyToOne(cascade = [CascadeType.ALL])
    @JsonBackReference
    @JoinColumn(name="blog_post_id")
    var blogPost: BlogPost,
)