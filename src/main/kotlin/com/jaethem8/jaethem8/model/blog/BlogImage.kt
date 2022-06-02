package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="blog_image")
data class BlogImage(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        val id:Long=0,
        @Column(name="location")
        val location:Int=0,
        @Column(name="image")
        val image:String="",
        @ManyToOne(cascade = [CascadeType.ALL])
        @JsonBackReference
        @JoinColumn(name="blog_post_id")
        var blogPost: BlogPost,
)