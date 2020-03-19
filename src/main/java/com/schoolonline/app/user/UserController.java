package com.schoolonline.app.user;

import com.schoolonline.app.common.utils.ResponseProcessor;
import com.schoolonline.app.user.dto.NewUserDTO;
import com.schoolonline.app.user.dto.StudentDTO;
import com.schoolonline.app.user.dto.TeacherDTO;
import com.schoolonline.app.user.error.UserError;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    private UserFacade userFacade;

    UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/students")
    ResponseEntity<?> addStudent(@RequestBody NewUserDTO newUserDTO) {
        Either<UserError, StudentDTO> studentDTO = userFacade.addStudent(newUserDTO);
        return ResponseProcessor.processResponse(studentDTO, HttpStatus.CREATED);
    }

    @PostMapping("/teachers")
    ResponseEntity<?> addTeacher(@RequestBody NewUserDTO newUserDTO) {
        Either<UserError, TeacherDTO> teacherDTO = userFacade.addTeacher(newUserDTO);
        return ResponseProcessor.processResponse(teacherDTO, HttpStatus.CREATED);
    }
}
