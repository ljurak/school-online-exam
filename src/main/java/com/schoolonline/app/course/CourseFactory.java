package com.schoolonline.app.course;

import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.error.CourseError;
import io.vavr.control.Either;

class CourseFactory {

    private CourseValidator courseValidator;

    private CourseRepository courseRepository;

    CourseFactory(CourseValidator courseValidator, CourseRepository courseRepository) {
        this.courseValidator = courseValidator;
        this.courseRepository = courseRepository;
    }

    Either<CourseError, Course> addCourse(NewCourseDTO newCourseDTO) {
        return courseValidator
                .validateCourse(newCourseDTO)
                .map(newCourse -> {
                   Course course = Course.fromDTO(newCourse);
                   return courseRepository.save(course);
                });
    }
}
