package com.schoolonline.app.course.dto;

import java.time.LocalDate;

public class CourseStudentDTO {

    private Long id;
    private Long studentId;
    private CourseDTO course;
    private LocalDate enrollDate;

    public CourseStudentDTO(Long id, Long studentId, CourseDTO course, LocalDate enrollDate) {
        this.id = id;
        this.studentId = studentId;
        this.course = course;
        this.enrollDate = enrollDate;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }
}
