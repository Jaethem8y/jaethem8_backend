package com.jaethem8.jaethem8.controller

import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.dto.security.RoleToUserDTO
import com.jaethem8.jaethem8.model.security.Role
import com.jaethem8.jaethem8.model.security.User

import com.jaethem8.jaethem8.service.blog.BlogService
import com.jaethem8.jaethem8.service.personal.PersonalService
import com.jaethem8.jaethem8.service.security.UserService
import com.jaethem8.jaethem8.service.study.StudyService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/admin")
class AdminController(
    private val blogService: BlogService,
    private val personalService: PersonalService,
    private val studyService: StudyService,
    private val userService: UserService
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

    @GetMapping("/users")
    fun getUsers():ResponseEntity<List<User>>{
        return ResponseEntity.ok().body(userService.getUsers())
    }
    @PostMapping("/user/save")
    fun saveUser(@RequestBody user:User):ResponseEntity<User>{
        val uri:URI = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/user/save").toString())
        return ResponseEntity.created(uri).body(userService.saveUser(user))
    }
    @PostMapping("/role/save")
    fun saveRole(@RequestBody role:Role):ResponseEntity<Role>{
        val uri:URI = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/role/save").toString())
        return ResponseEntity.created(uri).body(userService.saveRole(role))
    }
    @PostMapping("/role/addToUser")
    fun addRoleToUser(@RequestBody roleToUserDTO: RoleToUserDTO): ResponseEntity<User> {
        return ResponseEntity.ok().body(userService.addRoleToUser(roleToUserDTO.username,roleToUserDTO.roleName))
    }
}