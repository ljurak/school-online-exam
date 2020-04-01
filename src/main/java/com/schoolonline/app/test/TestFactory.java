package com.schoolonline.app.test;

import com.schoolonline.app.test.dto.NewQuestionDTO;
import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;
import io.vavr.control.Option;

class TestFactory {

    private TestValidator testValidator;

    private TestRepository testRepository;

    private QuestionRepository questionRepository;

    TestFactory(TestValidator testValidator, TestRepository testRepository, QuestionRepository questionRepository) {
        this.testValidator = testValidator;
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
    }

    Either<TestError, Test> addTest(NewTestDTO newTestDTO) {
        return testValidator
                .validateTest(newTestDTO)
                .map(newTest -> {
                    Test test = Test.fromDTO(newTest);
                    return testRepository.save(test);
                });
    }

    Either<TestError, Question> addQuestionToTest(NewQuestionDTO newQuestionDTO) {
        return testValidator
                .validateQuestion(newQuestionDTO)
                .flatMap(newQuestion -> {
                    Option<Test> test = testRepository.findTestById(newQuestion.getTestId());
                    if (test.isEmpty()) {
                        return Either.left(TestError.TEST_NOT_FOUND);
                    }
                    Question question = Question.of(newQuestion, test.get());
                    questionRepository.save(question);
                    return Either.right(question);
                });
    }
}
