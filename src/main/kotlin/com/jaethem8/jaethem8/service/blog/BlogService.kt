package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.dto.blog.BlogCodeDTO
import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogImageDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogCode
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogImage
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.repository.blog.BlogContentRepository
import com.jaethem8.jaethem8.repository.blog.BlogImageRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

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
    fun getBlogPostByTitle(title:String):BlogPost?{
        return blogPostRepository.findByTitle(title)
    }
    fun deleteBlogPostById(id:Long){
        return blogPostRepository.deleteById(id)
    }
    fun addBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        var blogPost = BlogPost()
        blogPost.pubDate = blogPostDTO.pubDate
        blogPost.pubTime = blogPostDTO.pubTime
        blogPost.title = blogPostDTO.title
        return blogPostRepository.save(blogPost)
    }
    @Transactional
    fun addBlogContent(blogContentDTO: BlogContentDTO):BlogPost{
        var blogContent = BlogContent()
        var blogPost = blogPostRepository.findByTitle(blogContentDTO.title)
        blogContent.content = blogContentDTO.content
        blogContent.location = blogContentDTO.location
        blogContent.blogPost = blogPost
        blogPost!!.blogContents += blogContent
        blogPostRepository.deleteByTitle(blogContentDTO.title)
        return blogPostRepository.save(blogPost)
    }
    @Transactional
    fun addBlogImage(blogImageDTO: BlogImageDTO):BlogPost{
        var blogImage = BlogImage()
        var blogPost = blogPostRepository.findByTitle(blogImageDTO.title)
        blogImage.image = blogImageDTO.image
        blogImage.location = blogImageDTO.location
        blogImage.blogPost = blogPost
        blogPost!!.blogImages += blogImage
        blogPostRepository.deleteByTitle(blogImageDTO.title)
        return blogPostRepository.save(blogPost)
    }
    @Transactional
    fun addBlogCode(blogCodeDTO: BlogCodeDTO):BlogPost{
        var blogCode = BlogCode()
        var blogPost = blogPostRepository.findByTitle(blogCodeDTO.title)
        blogCode.code = blogCodeDTO.code
        blogCode.location = blogCodeDTO.location
        blogCode.blogPost = blogPost
        blogPost!!.blogCodes += blogCode
        blogPostRepository.deleteByTitle(title)
        return blogPostRepository.save(blogPost)
    }

}