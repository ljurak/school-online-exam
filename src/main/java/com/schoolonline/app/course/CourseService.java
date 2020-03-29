package com.schoolonline.app.course;

import com.schoolonline.app.course.dto.CourseDTO;
import com.schoolonline.app.course.dto.CourseStudentDTO;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.dto.NewCourseStudentDTO;
import com.schoolonline.app.course.error.CourseError;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;

class CourseService {

    private CourseFactory courseFactory;

    private CourseRepository courseRepository;

    private CourseStudentRepository courseStudentRepository;

    CourseService(CourseFactory courseFactory, CourseRepository courseRepository, CourseStudentRepository courseStudentRepository) {
        this.courseFactory = courseFactory;
        this.courseRepository = courseRepository;
        this.courseStudentRepository = courseStudentRepository;
    }

    Either<CourseError, CourseDTO> addCourse(NewCourseDTO newCourseDTO) {
        return courseFactory
                .addCourse(newCourseDTO)
                .map(Course::toDTO);
    }

    Option<CourseDTO> findCourseById(Long id) {
        return courseRepository
                .findCourseById(id)
                .map(Course::toDTO);
    }

    List<CourseDTO> findCoursesByTeacherId(Long teacherId) {
        return courseRepository
                .findCoursesByTeacherId(teacherId)
                .map(Course::toDTO);
    }

    Either<CourseError, CourseStudentDTO> addStudentToCourse(NewCourseStudentDTO newCourseStudentDTO) {
        return courseRepository
            .findCourseById(newCourseStudentDTO.getCourseId())
            .toEither(CourseError.COURSE_NOT_FOUND)
            .flatMap(course -> {
                Option<CourseStudent> courseStudent =
                        courseStudentRepository.findCourseStudentByStudentIdAndCourse(newCourseStudentDTO.getStudentId(), course);
                if (courseStudent.isDefined()) {
                    return Either.left(CourseError.STUDENT_ALREADY_SIGNED);
                }
                return Either.right(course);
            })
            .map(course -> {
                CourseStudent courseStudent = CourseStudent.of(newCourseStudentDTO.getStudentId(), course);
                return courseStudentRepository.save(courseStudent);
            })
            .map(CourseStudent::toDTO);
    }
}
