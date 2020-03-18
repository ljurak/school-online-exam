package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.StudentDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;

public class UserFacade {

    private UserFactory userFactory;

    public UserFacade(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    public Either<UserError, StudentDTO> addStudent(NewUserDTO newUserDTO) {
        return userFactory
                .addStudent(newUserDTO)
                .map(Student::toDTO);
    }
}
