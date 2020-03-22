package com.schoolonline.app.course;

import io.vavr.collection.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findCoursesByTeacherId(Long teacherId);
}
