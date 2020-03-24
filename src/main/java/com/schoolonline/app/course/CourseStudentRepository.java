package com.schoolonline.app.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseStudentRepository extends CrudRepository<CourseStudent, Long> {
}
