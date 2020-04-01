package com.schoolonline.app.test;

import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.dto.TestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;

class TestService {

    private TestFactory testFactory;

    private TestRepository testRepository;

    TestService(TestFactory testFactory, TestRepository testRepository) {
        this.testFactory = testFactory;
        this.testRepository = testRepository;
    }

    Either<TestError, TestDTO> addTest(NewTestDTO newTestDTO) {
        return testFactory
                .addTest(newTestDTO)
                .map(Test::toDTO);
    }
}
