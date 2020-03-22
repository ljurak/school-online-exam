package com.schoolonline.app.course;

import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.error.CourseError;
import io.vavr.collection.List;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

public class CourseFacade {

    private CourseService courseService;

    public CourseFacade(CourseService courseService) {
        this.courseService = courseService;
    }

    @Transactional
    public Either<CourseError, CourseDTO> addCourse(NewCourseDTO newCourseDTO) {
        return courseService.addCourse(newCourseDTO);
    }

    public List<CourseDTO> findCoursesByTeacherId(Long teacherId) {
        return courseService.findCoursesByTeacherId(teacherId);
    }
}
