package com.schoolonline.app.user;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.user.dto.StudentDTO;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
class Student extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    User getUser() {
        return user;
    }

    Student() {
    }

    private Student(User user) {
        this.user = user;
    }

    static Student fromUser(User user) {
        return new Student(user);
    }

    StudentDTO toDTO() {
        return new StudentDTO(getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
