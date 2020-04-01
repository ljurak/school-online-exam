package com.schoolonline.app.test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface QuestionRepository extends CrudRepository<Question, Long> {
}
