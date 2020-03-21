package com.schoolonline.app.course;

import com.schoolonline.app.common.utils.ResponseProcessor;
import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.error.CourseError;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CourseController {

    private CourseFacade courseFacade;

    CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }

    @PostMapping("/courses")
    ResponseEntity<?> addCourse(@RequestBody NewCourseDTO newCourseDTO) {
        Either<CourseError, CourseDTO> courseDTO = courseFacade.addCourse(newCourseDTO);
        return ResponseProcessor.processResponse(courseDTO, HttpStatus.CREATED);
    }
}
