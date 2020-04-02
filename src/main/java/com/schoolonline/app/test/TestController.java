package com.schoolonline.app.test;

import com.schoolonline.app.common.utils.ResponseProcessor;
import com.schoolonline.app.test.dto.NewQuestionDTO;
import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.dto.QuestionDTO;
import com.schoolonline.app.test.dto.TestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestController {

    private TestFacade testFacade;

    TestController(TestFacade testFacade) {
        this.testFacade = testFacade;
    }

    @PostMapping("/tests")
    ResponseEntity<?> addTest(@RequestBody NewTestDTO newTestDTO) {
        Either<TestError, TestDTO> testDTO = testFacade.addTest(newTestDTO);
        return ResponseProcessor.processResponse(testDTO, HttpStatus.CREATED);
    }

    @PostMapping("/tests/{testId}/questions")
    ResponseEntity<?> addQuestionToTest(@RequestBody NewQuestionDTO newQuestionDTO, @PathVariable long testId) {
        newQuestionDTO.setTestId(testId);
        Either<TestError, QuestionDTO> questionDTO = testFacade.addQuestionToTest(newQuestionDTO);
        return ResponseProcessor.processResponse(questionDTO, HttpStatus.CREATED);
    }
}
