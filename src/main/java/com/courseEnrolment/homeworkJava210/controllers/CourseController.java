package com.courseEnrolment.homeworkJava210.controllers;

import com.courseEnrolment.homeworkJava210.models.Course;
import com.courseEnrolment.homeworkJava210.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hw2-10/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) throws Exception {
        return courseService.getCourseById(id);
    }




}