package com.schoolonline.app.course.dto;

import java.time.LocalDate;

public class CourseStudentDTO {

    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDate enrollDate;

    public CourseStudentDTO(Long id, Long studentId, Long courseId, LocalDate enrollDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollDate = enrollDate;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }
}
