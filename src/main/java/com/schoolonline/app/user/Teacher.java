package com.schoolonline.app.user;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.user.dto.TeacherDTO;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHERS")
class Teacher extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    User getUser() {
        return user;
    }

    TeacherDTO toDTO() {
        return new TeacherDTO(getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
