package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;

class UserFactory {

    private UserValidator userValidator;

    private UserRepository userRepository;

    private StudentRepository studentRepository;

    private TeacherRepository teacherRepository;

    UserFactory(
            UserValidator userValidator,
            UserRepository userRepository,
            StudentRepository studentRepository,
            TeacherRepository teacherRepository) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    Either<UserError, Student> addStudent(NewUserDTO newUserDTO) {
        return createUser(newUserDTO)
                .map(this::createStudent);
    }

    Either<UserError, Teacher> addTeacher(NewUserDTO newUserDTO) {
        return createUser(newUserDTO)
                .map(this::createTeacher);
    }

    private Either<UserError, User> createUser(NewUserDTO newUserDTO) {
        return userValidator
                .validateUser(newUserDTO)
                .map(newUser -> {
                    User user = User.fromDTO(newUser);
                    return userRepository.save(user);
                });
    }

    private Student createStudent(User user) {
        Student student = Student.fromUser(user);
        return studentRepository.save(student);
    }

    private Teacher createTeacher(User user) {
        Teacher teacher = Teacher.fromUser(user);
        return teacherRepository.save(teacher);
    }
}
