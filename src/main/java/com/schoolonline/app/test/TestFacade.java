package com.schoolonline.app.test;

import com.schoolonline.app.test.dto.NewQuestionDTO;
import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.dto.QuestionDTO;
import com.schoolonline.app.test.dto.TestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

public class TestFacade {

    private TestService testService;

    private QuestionService questionService;

    public TestFacade(TestService testService, QuestionService questionService) {
        this.testService = testService;
        this.questionService = questionService;
    }

    @Transactional
    public Either<TestError, TestDTO> addTest(NewTestDTO newTestDTO) {
        return testService.addTest(newTestDTO);
    }

    @Transactional
    public Either<TestError, QuestionDTO> addQuestionToTest(NewQuestionDTO newQuestionDTO) {
        return questionService.addQuestionToTest(newQuestionDTO);
    }
}
