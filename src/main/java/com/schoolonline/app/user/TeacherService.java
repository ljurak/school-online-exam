package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.TeacherDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;

class TeacherService {

    private UserFactory userFactory;

    private TeacherRepository teacherRepository;

    TeacherService(UserFactory userFactory, TeacherRepository teacherRepository) {
        this.userFactory = userFactory;
        this.teacherRepository = teacherRepository;
    }

    Either<UserError, TeacherDTO> addTeacher(NewUserDTO newUserDTO) {
        return userFactory
                .addTeacher(newUserDTO)
                .map(Teacher::toDTO);
    }
}
