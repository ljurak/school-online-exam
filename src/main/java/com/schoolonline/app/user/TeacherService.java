package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.TeacherDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;
import io.vavr.control.Option;

class TeacherService {

    private UserFactory userFactory;

    private TeacherRepository teacherRepository;

    private UserRepository userRepository;

    TeacherService(UserFactory userFactory, TeacherRepository teacherRepository, UserRepository userRepository) {
        this.userFactory = userFactory;
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    Either<UserError, TeacherDTO> addTeacher(NewUserDTO newUserDTO) {
        return userFactory
                .addTeacher(newUserDTO)
                .map(Teacher::toDTO);
    }

    Option<Teacher> findById(Long id) {
        return teacherRepository.findTeacherById(id);
    }

    void removeTeacherById(Long id) {
        teacherRepository.findTeacherById(id)
                .peek(teacher -> {
                   teacherRepository.delete(teacher);
                   userRepository.delete(teacher.getUser());
                });
    }
}
