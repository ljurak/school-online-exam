package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;

class UserFactory {

    private UserValidator userValidator;

    private UserRepository userRepository;

    private StudentRepository studentRepository;

    UserFactory(UserValidator userValidator, UserRepository userRepository, StudentRepository studentRepository) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    Either<UserError, Student> addStudent(NewUserDTO newUserDTO) {
        return userValidator
                .validateUser(newUserDTO)
                .map(this::createUser)
                .map(this::createStudent);
    }

    User createUser(NewUserDTO newUserDTO) {
        User user = User.fromDTO(newUserDTO);
        return userRepository.save(user);
    }

    Student createStudent(User user) {
        Student student = Student.fromUser(user);
        return studentRepository.save(student);
    }
}
