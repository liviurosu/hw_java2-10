package com.courseEnrolment.homeworkJava210.repositories;

import com.courseEnrolment.homeworkJava210.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}