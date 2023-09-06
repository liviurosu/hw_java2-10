package com.courseEnrolment.homeworkJava210;

import com.courseEnrolment.homeworkJava210.models.Course;
import com.courseEnrolment.homeworkJava210.models.Enrollment;
import com.courseEnrolment.homeworkJava210.models.Student;
import com.courseEnrolment.homeworkJava210.repositories.CourseRepository;
import com.courseEnrolment.homeworkJava210.repositories.EnrollmentRepository;
import com.courseEnrolment.homeworkJava210.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
public class EnrollmentSystemTests {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Test
    public void testCourseEnrollmentRelationship() {
        // Create a course
        Course course = new Course();
        course.setTitle("Math");
        course.setDescription("Mathematics course");
        courseRepository.save(course);

        // Create a student
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john@example.com");
        studentRepository.save(student);

        // Enroll the student in the course
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollmentRepository.save(enrollment);

        // Retrieve the course and verify the enrollment
        Course retrievedCourse = courseRepository.findById(course.getId()).get();
        assertEquals(1, retrievedCourse.getEnrollments().size());
        assertEquals(student.getName(), retrievedCourse.getEnrollments().get(0).getStudent().getName());
    }

    @Test
    public void testStudentEnrollmentRelationship() {
        // Create a course
        Course course1 = new Course();
        course1.setTitle("Physics");
        course1.setDescription("Physics course");
        courseRepository.save(course1);

        Course course2 = new Course();
        course2.setTitle("Chemistry");
        course2.setDescription("Chemistry course");
        courseRepository.save(course2);

        // Create a student
        Student student = new Student();
        student.setName("Alice");
        student.setEmail("alice@example.com");
        studentRepository.save(student);

        // Enroll the student in courses
        Enrollment enrollment1 = new Enrollment();
        enrollment1.setCourse(course1);
        enrollment1.setStudent(student);
        enrollmentRepository.save(enrollment1);

        Enrollment enrollment2 = new Enrollment();
        enrollment2.setCourse(course2);
        enrollment2.setStudent(student);
        enrollmentRepository.save(enrollment2);

        // Retrieve the student and verify the enrollments
        Student retrievedStudent = studentRepository.findById(student.getId()).get();
        assertEquals(2, retrievedStudent.getEnrollments().size());
    }
}