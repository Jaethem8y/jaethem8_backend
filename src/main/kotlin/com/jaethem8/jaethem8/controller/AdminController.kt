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
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/admin")
class AdminController(
    private val blogService: BlogService,
    private val personalService: PersonalService,
    private val studyService: StudyService
){
    @GetMapping("/blogPost")
    fun getAllBlogPost(): List<BlogPost> {
        return blogService.getAllBlogPost();
    }
    @GetMapping("/blogPost/{id}")
    fun getBlogPostById(@PathVariable id:Long):BlogPost?{
        return blogService.getBlogPostById(id)
    }
    @PostMapping("/blogPost")
    fun addBlogPost(@RequestBody blogPost: BlogPost): BlogPost{
        return blogService.addBlogPost(blogPost)
    }
    @PostMapping("/update/blogPost")
    fun updateBlogPost(@RequestBody blogPost: BlogPost): BlogPost {
        return blogService.updateBlogPost(blogPost)
    }
    @DeleteMapping("/blogPost")
    fun deleteBlogPost(@RequestBody blogPost: BlogPost){
        return blogService.deleteBlogPostById(blogPost.id)
    }


    @GetMapping("/studyPost")
    fun getAllStudyPost():List<StudyPost>{
        return studyService.getAllStudyPost()
    }
    @GetMapping("/studyPost/{id}")
    fun getStudyPostById(@PathVariable id:Long): StudyPost? {
        return studyService.getStudyPostById(id)
    }
    @PostMapping("/studyPost")
    fun addStudyPost(@RequestBody studyPost: StudyPost): StudyPost {
        return studyService.addStudyPost(studyPost)
    }
    @PostMapping("/update/studyPost")
    fun updateStudyPost(@RequestBody studyPost: StudyPost):StudyPost{
        return studyService.updateStudyPost(studyPost)
    }


    @GetMapping("/personalPost")
    fun getAllPersonalContent(): List<PersonalPost> {
        return personalService.getAllPersonalPost()
    }
    @GetMapping("/personalPost/{id}")
    fun getPersonalContentById(@PathVariable id:Long): PersonalPost? {
        return personalService.getPersonalPostById(id)
    }
    @PostMapping("/personalPost")
    fun addPersonalContent(@RequestBody personalPost: PersonalPost): PersonalPost {
        return personalService.addPersonalPost(personalPost)
    }
    @PostMapping("/update/personalPost")
    fun updatePersonalContent(@RequestBody personalPost: PersonalPost): PersonalPost {
        return personalService.updatePersonalPost(personalPost)
    }

}