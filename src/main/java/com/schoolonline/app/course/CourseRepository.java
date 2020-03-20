package com.schoolonline.app.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends CrudRepository<Course, Long> {
}
