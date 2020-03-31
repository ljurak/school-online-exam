package com.schoolonline.app.test;

import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.dto.TestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;
import org.springframework.transaction.annotation.Transactional;

public class TestFacade {

    private TestService testService;

    public TestFacade(TestService testService) {
        this.testService = testService;
    }

    @Transactional
    public Either<TestError, TestDTO> addTest(NewTestDTO newTestDTO) {
        return testService.addTest(newTestDTO);
    }
}
