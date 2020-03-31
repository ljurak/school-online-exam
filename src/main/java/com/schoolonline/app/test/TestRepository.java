package com.schoolonline.app.test;

import io.vavr.control.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TestRepository extends CrudRepository<Test, Long> {

    Option<Test> findTestById(Long id);
}
