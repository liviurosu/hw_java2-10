package com.courseEnrolment.homeworkJava210.controllers;

import com.courseEnrolment.homeworkJava210.models.Student;
import com.courseEnrolment.homeworkJava210.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hw2-10/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) throws Exception {
        return studentService.getStudentById(id);
    }



}