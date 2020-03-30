package com.schoolonline.app.test;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.test.dto.NewTestDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TESTS")
class Test extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private LocalDate activeFrom;

    @Column(nullable = false)
    private LocalDate activeTo;

    Test() {
    }

    private Test(String name, Long courseId, LocalDate activeFrom, LocalDate activeTo) {
        this.name = name;
        this.courseId = courseId;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
    }

    static Test fromDTO(NewTestDTO newTestDTO) {
        return new Test(
                newTestDTO.getName(),
                newTestDTO.getCourseId(),
                newTestDTO.getActiveFrom(),
                newTestDTO.getActiveTo()
        );
    }
}
