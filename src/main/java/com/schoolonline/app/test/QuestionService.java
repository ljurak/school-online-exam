package com.schoolonline.app.test;

import com.schoolonline.app.test.dto.NewQuestionDTO;
import com.schoolonline.app.test.dto.QuestionDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;

class QuestionService {

    private TestFactory testFactory;

    private QuestionRepository questionRepository;

    QuestionService(TestFactory testFactory, QuestionRepository questionRepository) {
        this.testFactory = testFactory;
        this.questionRepository = questionRepository;
    }

    Either<TestError, QuestionDTO> addQuestionToTest(NewQuestionDTO newQuestionDTO) {
        return testFactory
                .addQuestionToTest(newQuestionDTO)
                .map(Question::toDTO);
    }
}
