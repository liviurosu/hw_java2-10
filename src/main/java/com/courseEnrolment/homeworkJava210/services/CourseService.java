package com.courseEnrolment.homeworkJava210.services;

import com.courseEnrolment.homeworkJava210.models.Course;
import com.courseEnrolment.homeworkJava210.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepo;

    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course getCourseById(Long id) throws Exception {
        return courseRepo.findById(id)
                .orElseThrow(() -> new Exception("Course not found with id " + id));
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }


}