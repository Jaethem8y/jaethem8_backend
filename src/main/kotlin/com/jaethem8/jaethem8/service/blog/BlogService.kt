package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.repository.blog.BlogContentRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class BlogService(
    private val blogContentRepository: BlogContentRepository,
    private val blogPostRepository: BlogPostRepository
) {
    fun getAllBlogPost():List<BlogPost>{
        return blogPostRepository.findAll()
    }
    fun getBlogPostById(id:Long): BlogPost? {
        return blogPostRepository.findByIdOrNull(id)
    }
    fun getBlogPostByTitle(title:String):BlogPost?{
        return blogPostRepository.findByTitle(title)
    }
    fun deleteBlogPostByTitle(title:String){
        return blogPostRepository.deleteByTitle(title)
    }

    fun addBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        var blogPost = BlogPost()
        blogPost.pubDate = blogPostDTO.pubDate
        blogPost.title = blogPostDTO.title
        return blogPostRepository.save(blogPost)
    }
    @Transactional
    fun addBlogContent(blogContentDTO: BlogContentDTO):BlogPost{
        var blogContent = BlogContent()
        var blogPost = blogPostRepository.findByTitle(blogContentDTO.title)
        blogContent.content = blogContentDTO.content
        blogContent.location = blogContentDTO.location
        blogContent.code = blogContentDTO.code
        blogContent.image = blogContentDTO.image
        blogContent.blogPost = blogPost
        blogPost!!.blogContents += blogContent
        return blogPostRepository.save(blogPost)
    }
}