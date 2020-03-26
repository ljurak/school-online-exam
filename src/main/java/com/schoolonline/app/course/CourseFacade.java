package com.schoolonline.app.course;

import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.CourseStudentDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.dto.NewCourseStudentDTO;
import com.schoolonline.app.course.error.CourseError;
import com.schoolonline.app.user.UserFacade;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.transaction.annotation.Transactional;

public class CourseFacade {

    private CourseService courseService;

    private UserFacade userFacade;

    public CourseFacade(CourseService courseService, UserFacade userFacade) {
        this.courseService = courseService;
        this.userFacade = userFacade;
    }

    @Transactional
    public Either<CourseError, CourseDTO> addCourse(NewCourseDTO newCourseDTO) {
        return courseService.addCourse(newCourseDTO);
    }

    public Option<CourseDTO> findCourseById(Long id) {
        return courseService.findCourseById(id);
    }

    public List<CourseDTO> findCoursesByTeacherId(Long teacherId) {
        return courseService.findCoursesByTeacherId(teacherId);
    }

    @Transactional
    public Either<CourseError, CourseStudentDTO> addStudentToCourse(NewCourseStudentDTO newCourseStudentDTO) {
        return userFacade
                .findStudentById(newCourseStudentDTO.getStudentId())
                .toEither(CourseError.STUDENT_NOT_FOUND)
                .flatMap(s -> courseService.addStudentToCourse(newCourseStudentDTO));
    }
}
