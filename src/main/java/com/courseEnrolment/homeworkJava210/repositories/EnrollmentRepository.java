package com.courseEnrolment.homeworkJava210.repositories;

import com.courseEnrolment.homeworkJava210.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findAllByStudent_Id(Long studentId);

    List<Enrollment> findAllByCourse_Id(Long courseId);
}