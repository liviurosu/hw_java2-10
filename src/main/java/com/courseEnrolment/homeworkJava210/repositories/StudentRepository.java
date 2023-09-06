package com.courseEnrolment.homeworkJava210.repositories;

import com.courseEnrolment.homeworkJava210.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}