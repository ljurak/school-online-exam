package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.StudentDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;

class StudentService {

    private UserFactory userFactory;

    private StudentRepository studentRepository;

    StudentService(UserFactory userFactory, StudentRepository studentRepository) {
        this.userFactory = userFactory;
        this.studentRepository = studentRepository;
    }

    Either<UserError, StudentDTO> addStudent(NewUserDTO newUserDTO) {
        return userFactory
                .addStudent(newUserDTO)
                .map(Student::toDTO);
    }
}
