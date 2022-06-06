package com.jaethem8.jaethem8.controller

import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.service.blog.BlogService
import com.jaethem8.jaethem8.service.personal.PersonalService
import com.jaethem8.jaethem8.service.study.StudyService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val blogService: BlogService,
    private val personalService: PersonalService,
    private val studyService: StudyService
){
    @CrossOrigin
    @GetMapping("/blogPost")
    fun getAllBlogPost(): List<BlogPost> {
        return blogService.getAllBlogPost();
    }
    @CrossOrigin

    @GetMapping("/blogPost/{title}")
    fun getBlogPostById(@PathVariable title:String):BlogPost?{
        return blogService.getBlogPostByTitle(title)
    }
    @CrossOrigin

    @GetMapping("/studyPost")
    fun getAllStudyPost():List<StudyPost>{
        return studyService.getAllStudyPost()
    }
    @CrossOrigin
    @GetMapping("/studyPost/{title}")
    fun getStudyPostById(@PathVariable title:String): StudyPost? {
        return studyService.getStudyPostByTitle(title)
    }
    @CrossOrigin
    @GetMapping("/personalPost")
    fun getAllPersonalContent(): List<PersonalPost> {
        return personalService.getAllPersonalPost()
    }
    @CrossOrigin
    @GetMapping("/personalPost/{title}")
    fun getPersonalContentById(@PathVariable title:String): PersonalPost? {
        return personalService.getPersonalPostByTitle(title)
    }
}