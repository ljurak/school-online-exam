package com.schoolonline.app.course;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends CrudRepository<Course, Long> {

    Option<Course> findCourseById(Long id);

    List<Course> findCoursesByTeacherId(Long teacherId);
}
