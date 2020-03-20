package com.schoolonline.app.course;

import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.error.CourseError;
import io.vavr.control.Either;

class CourseService {

    private CourseFactory courseFactory;

    private CourseRepository courseRepository;

    CourseService(CourseFactory courseFactory, CourseRepository courseRepository) {
        this.courseFactory = courseFactory;
        this.courseRepository = courseRepository;
    }

    Either<CourseError, CourseDTO> addCourse(NewCourseDTO newCourseDTO) {
        return courseFactory
                .addCourse(newCourseDTO)
                .map(Course::toDTO);
    }
}
