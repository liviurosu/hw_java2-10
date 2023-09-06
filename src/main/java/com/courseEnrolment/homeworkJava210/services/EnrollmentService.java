package com.courseEnrolment.homeworkJava210.services;

import com.courseEnrolment.homeworkJava210.models.Course;
import com.courseEnrolment.homeworkJava210.models.Enrollment;
import com.courseEnrolment.homeworkJava210.models.Student;
import com.courseEnrolment.homeworkJava210.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepo;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    public Enrollment enrollStudentInCourse(Long courseId, Long studentId) throws Exception {
        Course course = courseService.getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);

        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setEnrollmentDate(new Date());

        return enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepo.findAllByStudent_Id(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepo.findAllByCourse_Id(courseId);
    }


}