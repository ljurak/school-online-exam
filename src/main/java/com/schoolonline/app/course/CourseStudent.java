package com.schoolonline.app.course;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.course.dto.CourseStudentDTO;
import com.schoolonline.app.course.dto.NewCourseStudentDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "COURSES_STUDENTS")
class CourseStudent extends BaseEntity {

    @Column(nullable = false)
    private Long studentId;

    @Column(nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private LocalDate enrollDate;

    CourseStudent() {
    }

    private CourseStudent(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollDate = LocalDate.now();
    }

    Long getStudentId() {
        return studentId;
    }

    Long getCourseId() {
        return courseId;
    }

    LocalDate getEnrollDate() {
        return enrollDate;
    }

    static CourseStudent fromDTO(NewCourseStudentDTO newCourseStudentDTO) {
        return new CourseStudent(
                newCourseStudentDTO.getStudentId(),
                newCourseStudentDTO.getCourseId()
        );
    }

    CourseStudentDTO toDTO() {
        return new CourseStudentDTO(getId(), studentId, courseId, enrollDate);
    }
}
