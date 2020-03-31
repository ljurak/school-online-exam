package com.schoolonline.app.test.dto;

import java.time.LocalDate;

public class TestDTO {

    private Long id;
    private String name;
    private LocalDate activeFrom;
    private LocalDate activeTo;
    private Long courseId;

    public TestDTO(Long id, String name, LocalDate activeFrom, LocalDate activeTo, Long courseId) {
        this.id = id;
        this.name = name;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public Long getCourseId() {
        return courseId;
    }
}
