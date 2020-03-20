package com.schoolonline.app.user;

import io.vavr.control.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository extends CrudRepository<Student, Long> {

    Option<Student> findStudentById(Long id);
}
