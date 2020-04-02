package com.schoolonline.app.test;

import com.schoolonline.app.common.utils.Validator;
import com.schoolonline.app.course.CourseFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TestConfiguration {

    @Bean
    TestFacade testFacade(CourseFacade courseFacade, TestRepository testRepository, QuestionRepository questionRepository) {
        TestValidator testValidator = new TestValidator(new Validator(), courseFacade);
        TestFactory testFactory = new TestFactory(testValidator, testRepository, questionRepository);
        TestService testService = new TestService(testFactory, testRepository);
        QuestionService questionService = new QuestionService(testFactory, questionRepository);
        return new TestFacade(testService, questionService);
    }
}
