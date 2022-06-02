package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.repository.blog.BlogContentRepository
import com.jaethem8.jaethem8.repository.blog.BlogImageRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class BlogService(
    private val blogContentRepository: BlogContentRepository,
    private val blogImageRepository: BlogImageRepository,
    private val blogPostRepository: BlogPostRepository
) {
    fun getAllBlogPost():List<BlogPost>{
        return blogPostRepository.findAll()
    }
    fun getBlogPostById(id:Long): BlogPost? {
        return blogPostRepository.findByIdOrNull(id)
    }
    fun deleteBlogPostById(id:Long){
        return blogPostRepository.deleteById(id)
    }
    fun addBlogPost(blogPost: BlogPost): BlogPost {
        blogPost.blogContents.forEach{it.blogPost = blogPost}
        blogPost.blogCode.forEach{it.blogPost = blogPost}
        blogPost.blogImages.forEach{it.blogPost = blogPost}
        return blogPostRepository.save(blogPost)
    }
    fun updateBlogPost(blogPost: BlogPost): BlogPost{
        deleteBlogPostById(blogPost.id)
        blogPost.blogContents.forEach{it.blogPost = blogPost}
        blogPost.blogCode.forEach{it.blogPost = blogPost}
        blogPost.blogImages.forEach{it.blogPost = blogPost}
        return addBlogPost(blogPost)
    }
}