package com.schoolonline.app.course;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "COURSES")
class Course extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Long teacherId;

    Course() {
    }

    private Course(String name, LocalDate startDate, LocalDate endDate, Long teacherId) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    String getName() {
        return name;
    }

    LocalDate getStartDate() {
        return startDate;
    }

    LocalDate getEndDate() {
        return endDate;
    }

    Long getTeacherId() {
        return teacherId;
    }

    static Course fromDTO(NewCourseDTO newCourseDTO) {
        return new Course(
                newCourseDTO.getName(),
                newCourseDTO.getStartDate(),
                newCourseDTO.getEndDate(),
                newCourseDTO.getTeacherId()
        );
    }

    CourseDTO toDTO() {
        return new CourseDTO(getId(), name, startDate, endDate, teacherId);
    }
}
