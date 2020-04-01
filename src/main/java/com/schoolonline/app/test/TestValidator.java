package com.schoolonline.app.test;

import com.schoolonline.app.common.utils.Validator;
import com.schoolonline.app.course.CourseFacade;
import com.schoolonline.app.test.dto.NewQuestionDTO;
import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;

class TestValidator {

    private Validator validator;

    private CourseFacade courseFacade;

    TestValidator(Validator validator, CourseFacade courseFacade) {
        this.validator = validator;
        this.courseFacade = courseFacade;
    }

    Either<TestError, NewTestDTO> validateTest(NewTestDTO newTestDTO) {
        return validateName(newTestDTO)
                .flatMap(this::validateActiveFrom)
                .flatMap(this::validateActiveTo)
                .flatMap(this::validateCourseId);
    }

    Either<TestError, NewQuestionDTO> validateQuestion(NewQuestionDTO newQuestionDTO) {
        return validateDescription(newQuestionDTO)
                .flatMap(this::validateAnswers)
                .flatMap(this::validateCorrectAnswer);
    }

    private Either<TestError, NewTestDTO> validateName(NewTestDTO newTestDTO) {
        if (validator.isBlank(newTestDTO.getName())) {
            return Either.left(TestError.MISSING_NAME);
        } else if (!validator.hasMaxLength(newTestDTO.getName(), 255)) {
            return Either.left(TestError.INVALID_NAME);
        }

        return Either.right(newTestDTO);
    }

    private Either<TestError, NewTestDTO> validateActiveFrom(NewTestDTO newTestDTO) {
        if (validator.isNull(newTestDTO.getActiveFrom())) {
            return Either.left(TestError.MISSING_ACTIVE_FROM);
        } else if (!validator.isPresentOrFutureDate(newTestDTO.getActiveFrom())) {
            return Either.left(TestError.INVALID_ACTIVE_FROM);
        }

        return Either.right(newTestDTO);
    }

    private Either<TestError, NewTestDTO> validateActiveTo(NewTestDTO newTestDTO) {
        if (validator.isNull(newTestDTO.getActiveTo())) {
            return Either.left(TestError.MISSING_ACTIVE_TO);
        } else if (!validator.isEarlierDate(newTestDTO.getActiveFrom(), newTestDTO.getActiveTo())) {
            return Either.left(TestError.INVALID_ACTIVE_TO);
        }

        return Either.right(newTestDTO);
    }

    private Either<TestError, NewTestDTO> validateCourseId(NewTestDTO newTestDTO) {
        if (validator.isNull(newTestDTO.getCourseId())) {
            return Either.left(TestError.MISSING_COURSE_ID);
        } else if (courseFacade.findCourseById(newTestDTO.getCourseId()).isEmpty()) {
            return Either.left(TestError.COURSE_NOT_FOUND);
        }

        return Either.right(newTestDTO);
    }

    private Either<TestError, NewQuestionDTO> validateDescription(NewQuestionDTO newQuestionDTO) {
        if (validator.isBlank(newQuestionDTO.getDescription())) {
            return Either.left(TestError.MISSING_DESCRIPTION);
        } else if (!validator.hasMaxLength(newQuestionDTO.getDescription(), 1000)) {
            return Either.left(TestError.INVALID_DESCRIPTION);
        }

        return Either.right(newQuestionDTO);
    }

    private Either<TestError, NewQuestionDTO> validateAnswers(NewQuestionDTO newQuestionDTO) {
        String[] answers = new String[] {
                newQuestionDTO.getAnswerA(),
                newQuestionDTO.getAnswerB(),
                newQuestionDTO.getAnswerC(),
                newQuestionDTO.getAnswerD()
        };

        for (String answer : answers) {
            if (validator.isBlank(answer)) {
                return Either.left(TestError.MISSING_ANSWERS);
            } else if (!validator.hasMaxLength(answer, 255)) {
                return Either.left(TestError.INVALID_ANSWERS);
            }
        }

        return Either.right(newQuestionDTO);
    }

    private Either<TestError, NewQuestionDTO> validateCorrectAnswer(NewQuestionDTO newQuestionDTO) {
        if (validator.isNull(newQuestionDTO.getCorrectAnswer())) {
            return Either.left(TestError.MISSING_CORRECT_ANSWER);
        }

        return Either.right(newQuestionDTO);
    }
}
