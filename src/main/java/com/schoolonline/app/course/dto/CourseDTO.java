package com.schoolonline.app.course.dto;

import java.time.LocalDate;

public class CourseDTO {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long teacherId;

    public CourseDTO(Long id, String name, LocalDate startDate, LocalDate endDate, Long teacherId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getTeacherId() {
        return teacherId;
    }
}
