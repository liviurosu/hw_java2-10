package com.courseEnrolment.homeworkJava210.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {
    private Long courseId;
    private Long studentId;


}