package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.StudentDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;
import io.vavr.control.Option;

class StudentService {

    private UserFactory userFactory;

    private StudentRepository studentRepository;

    private UserRepository userRepository;

    StudentService(UserFactory userFactory, StudentRepository studentRepository, UserRepository userRepository) {
        this.userFactory = userFactory;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    Either<UserError, StudentDTO> addStudent(NewUserDTO newUserDTO) {
        return userFactory
                .addStudent(newUserDTO)
                .map(Student::toDTO);
    }

    void removeStudentById(Long id) {
        studentRepository.findStudentById(id)
                .peek(student -> {
                    studentRepository.delete(student);
                    userRepository.delete(student.getUser());
                });
    }
}
