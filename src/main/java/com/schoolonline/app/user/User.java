package com.schoolonline.app.user;

import com.schoolonline.app.common.entity.BaseEntity;
import com.schoolonline.app.user.dto.NewUserDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
class User extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    User() {
    }

    private User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    static User fromDTO(NewUserDTO newUserDTO) {
        return new User(
                newUserDTO.getFirstName(),
                newUserDTO.getLastName(),
                newUserDTO.getEmail(),
                newUserDTO.getPassword()
        );
    }
}
