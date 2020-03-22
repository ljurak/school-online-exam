package com.schoolonline.app.user;

import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.StudentDTO;
import com.schoolonline.app.user.dto.TeacherDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;
import io.vavr.control.Option;
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

    public Option<TeacherDTO> findTeacherById(Long id) {
        return teacherService
                .findById(id)
                .map(Teacher::toDTO);
    }

    @Transactional
    public void removeStudentById(Long id) {
        studentService.removeStudentById(id);
    }

    @Transactional
    public void removeTeacherById(Long id) {
        teacherService.removeTeacherById(id);
    }
}
