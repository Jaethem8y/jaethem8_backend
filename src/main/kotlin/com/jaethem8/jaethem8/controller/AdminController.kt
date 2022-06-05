package com.jaethem8.jaethem8.controller

import com.jaethem8.jaethem8.dto.blog.BlogCodeDTO
import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogImageDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.service.blog.BlogService
import com.jaethem8.jaethem8.service.personal.PersonalService
import com.jaethem8.jaethem8.service.study.StudyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
@RequestMapping("/admin")
class AdminController(
    private val blogService: BlogService,
    private val personalService: PersonalService,
    private val studyService: StudyService
){
    @GetMapping("/blog/add")
    fun getAllBlogPost(): String {
        return "blog/blogPostAdd";
    }
    @PostMapping("/blog/addPost")
    fun addBlogPost(@RequestBody blogPostDTO: BlogPostDTO):String{
        return "/blog/blogPostAdd"
    }
    @PostMapping("/blog/addContent")
    fun addBlogContent(@RequestBody blogContentDTO:BlogContentDTO):String{
        return "/blog/blogContentAdd"
    }
    @PostMapping("/blog/addImage")
    fun addBlogImage(@RequestBody blogImageDTO: BlogImageDTO):String{
        return "/blog/blogImageAdd"
    }
    @PostMapping("/blog/addCode")
    fun addBlogCode(@RequestBody blogCodeDTO: BlogCodeDTO):String{
        return "/blog/blogCodeAdd"
    }
}