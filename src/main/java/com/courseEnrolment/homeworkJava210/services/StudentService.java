package com.courseEnrolment.homeworkJava210.services;

import com.courseEnrolment.homeworkJava210.models.Student;
import com.courseEnrolment.homeworkJava210.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student getStudentById(Long id) throws Exception {
        return studentRepo.findById(id)
                .orElseThrow(() -> new Exception("Student not found with id " + id));
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


}