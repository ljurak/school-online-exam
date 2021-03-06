package com.schoolonline.app.course;

import io.vavr.control.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface CourseStudentRepository extends CrudRepository<CourseStudent, Long> {

    @Query("select cs from CourseStudent cs where cs.studentId = :studentId and cs.course = :course")
    Option<CourseStudent> findCourseStudentByStudentIdAndCourse(@Param("studentId") Long studentId, @Param("course") Course course);
}
