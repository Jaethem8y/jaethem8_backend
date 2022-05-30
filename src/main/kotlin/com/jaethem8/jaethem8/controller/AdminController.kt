package com.jaethem8.jaethem8.controller

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
    private val courseService: CourseService
){

    @GetMapping("/course")
    fun getCourses():List<Course>{
        return courseService.getCourses();
    }
    @GetMapping("/course/{id}")
    fun getCourses(@PathVariable id:Long): Optional<Course> {
        return courseService.getCourse(id);
    }
    @PostMapping("delete/course")
    fun deleteCourse(@RequestBody id:String){
        val id:Long = id.toLong()
        return courseService.deleteCourse(id)
    }
    @PostMapping("add/course")
    fun addCourse(@RequestBody course:Course): Course {
        return courseService.addCourse(course)
    }
}