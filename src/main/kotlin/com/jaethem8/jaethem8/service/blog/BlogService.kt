package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.repository.blog.BlogContentRepository
import com.jaethem8.jaethem8.repository.blog.BlogImageRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val blogContentRepository: BlogContentRepository,
    private val blogImageRepository: BlogImageRepository,
    private val blogPostRepository: BlogPostRepository
) {
}