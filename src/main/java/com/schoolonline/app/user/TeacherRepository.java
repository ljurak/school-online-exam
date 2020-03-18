package com.schoolonline.app.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
