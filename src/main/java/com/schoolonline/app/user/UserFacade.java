package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.StudentDTO;
import com.schoolonline.app.user.dto.TeacherDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

public class UserFacade {

    private StudentService studentService;

    private TeacherService teacherService;

    public UserFacade(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Transactional
    public Either<UserError, StudentDTO> addStudent(NewUserDTO newUserDTO) {
        return studentService.addStudent(newUserDTO);
    }

    @Transactional
    public Either<UserError, TeacherDTO> addTeacher(NewUserDTO newUserDTO) {
        return teacherService.addTeacher(newUserDTO);
    }
}
