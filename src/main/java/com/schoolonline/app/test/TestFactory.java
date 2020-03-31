package com.schoolonline.app.test;

import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;

class TestFactory {

    private TestValidator testValidator;

    private TestRepository testRepository;

    public TestFactory(TestValidator testValidator, TestRepository testRepository) {
        this.testValidator = testValidator;
        this.testRepository = testRepository;
    }

    Either<TestError, Test> addTest(NewTestDTO newTestDTO) {
        return testValidator
                .validateTest(newTestDTO)
                .map(newTest -> {
                    Test test = Test.fromDTO(newTest);
                    return testRepository.save(test);
                });
    }
}
