package com.jaethem8.jaethem8.controller

import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.model.personal.PersonalContent
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.service.blog.BlogService
import com.jaethem8.jaethem8.service.personal.PersonalService
import com.jaethem8.jaethem8.service.study.StudyService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller

@Controller
@RequestMapping("/admin")
class AdminController(
    private val blogService: BlogService,
    private val personalService: PersonalService,
    private val studyService: StudyService
){
    @GetMapping("/blogPost")
    fun getAllBlogPost(): String{
        var blogPosts = blogService.getAllBlogPost();
        return ""
    }
}