package com.schoolonline.app.user;

import io.vavr.control.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Option<Teacher> findTeacherById(Long id);
}
