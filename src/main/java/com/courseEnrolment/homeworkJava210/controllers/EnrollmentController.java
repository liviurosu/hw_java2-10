package com.courseEnrolment.homeworkJava210.controllers;

import com.courseEnrolment.homeworkJava210.models.Enrollment;
import com.courseEnrolment.homeworkJava210.models.EnrollmentRequest;
import com.courseEnrolment.homeworkJava210.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hw2-10/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment enrollStudentInCourse(@RequestBody EnrollmentRequest enrollmentRequest) throws Exception {
        // Assuming you have a request class with courseId and studentId
        return enrollmentService.enrollStudentInCourse(enrollmentRequest.getCourseId(), enrollmentRequest.getStudentId());
    }

    @GetMapping("/students/{studentId}")
    public List<Enrollment> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }

    @GetMapping("/courses/{courseId}")
    public List<Enrollment> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

}