package com.jaethem8.jaethem8.controller

import com.jaethem8.jaethem8.dto.blog.BlogCodeDTO
import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogImageDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO

import com.jaethem8.jaethem8.service.blog.BlogService
import com.jaethem8.jaethem8.service.personal.PersonalService
import com.jaethem8.jaethem8.service.study.StudyService
import org.springframework.web.bind.annotation.GetMapping
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
    @GetMapping("/blog/addPost")
    fun getAddBlogPost(model:Model): String {
        model.addAttribute("blogPostDTO",BlogPostDTO())
        return "blog/blogPostAdd";
    }
    @PostMapping("/blog/addPost")
    fun addBlogPost(@ModelAttribute blogPostDTO: BlogPostDTO):String{
        blogService.addBlogPost(blogPostDTO)
        return "/blog/blogPostAdd"
    }
    @GetMapping("/blog/addContent")
    fun getAddBlogContent(model:Model): String {
        model.addAttribute("blogContentDTO",BlogContentDTO())
        return "blog/blogContentAdd";
    }
    @PostMapping("/blog/addContent")
    fun addBlogContent(@ModelAttribute blogContentDTO:BlogContentDTO):String{
        blogService.addBlogContent(blogContentDTO)
        return "/blog/blogContentAdd"
    }
    @GetMapping("/blog/addImage")
    fun getAddBlogImage(model:Model): String {
        model.addAttribute("blogImageDTO",BlogImageDTO())
        return "blog/blogImageAdd";
    }
    @PostMapping("/blog/addImage")
    fun addBlogImage(@ModelAttribute blogImageDTO: BlogImageDTO):String{
        blogService.addBlogImage(blogImageDTO)
        return "/blog/blogImageAdd"
    }
    @GetMapping("/blog/addCode")
    fun getAddBlogCode(model:Model): String {
        model.addAttribute("blogCodeDTO",BlogCodeDTO())
        return "blog/blogCodeAdd";
    }
    @PostMapping("/blog/addCode")
    fun addBlogCode(@ModelAttribute blogCodeDTO: BlogCodeDTO):String{
        blogService.addBlogCode(blogCodeDTO)
        return "/blog/blogCodeAdd"
    }
}