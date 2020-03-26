package com.schoolonline.app.course;

import com.schoolonline.app.common.utils.ResponseProcessor;
import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.CourseStudentDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.dto.NewCourseStudentDTO;
import com.schoolonline.app.course.error.CourseError;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/courses/{courseId}")
    ResponseEntity<?> getCourse(@PathVariable long courseId) {
        Option<CourseDTO> course = courseFacade.findCourseById(courseId);
        return ResponseProcessor.processResponse(course, CourseError.COURSE_NOT_FOUND, HttpStatus.OK);
    }

    @GetMapping("/teachers/{teacherId}/courses")
    ResponseEntity<?> findTeacherCourses(@PathVariable long teacherId) {
        List<CourseDTO> courses = courseFacade.findCoursesByTeacherId(teacherId);
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/courses/{courseId}/students")
    ResponseEntity<?> addStudentToCourse(@RequestBody NewCourseStudentDTO newCourseStudentDTO, @PathVariable long courseId) {
        newCourseStudentDTO.setCourseId(courseId);
        Either<CourseError, CourseStudentDTO> courseStudentDTO = courseFacade.addStudentToCourse(newCourseStudentDTO);
        return ResponseProcessor.processResponse(courseStudentDTO, HttpStatus.CREATED);
    }
}
