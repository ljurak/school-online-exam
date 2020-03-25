package com.schoolonline.app.course;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.course.dto.CourseStudentDTO;
import com.schoolonline.app.course.dto.NewCourseStudentDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "COURSES_STUDENTS")
class CourseStudent extends BaseEntity {

    @Column(nullable = false)
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private Course course;

    @Column(nullable = false)
    private LocalDate enrollDate;

    CourseStudent() {
    }

    private CourseStudent(Long studentId, Course course) {
        this.studentId = studentId;
        this.course = course;
        this.enrollDate = LocalDate.now();
    }

    Long getStudentId() {
        return studentId;
    }

    Course getCourse() {
        return course;
    }

    LocalDate getEnrollDate() {
        return enrollDate;
    }

    static CourseStudent of(Long studentId, Course course) {
        return new CourseStudent(studentId, course);
    }

    CourseStudentDTO toDTO() {
        return new CourseStudentDTO(getId(), studentId, course.toDTO(), enrollDate);
    }
}
