package com.schoolonline.app.test;

import com.schoolonline.app.common.utils.Validator;
import com.schoolonline.app.course.CourseFacade;
import com.schoolonline.app.test.dto.NewTestDTO;
import com.schoolonline.app.test.error.TestError;
import io.vavr.control.Either;

class TestValidator {

    private Validator validator;

    private CourseFacade courseFacade;

    public TestValidator(Validator validator, CourseFacade courseFacade) {
        this.validator = validator;
        this.courseFacade = courseFacade;
    }

    Either<TestError, NewTestDTO> validateTest(NewTestDTO newTestDTO) {
        return validateName(newTestDTO)
                .flatMap(this::validateActiveFrom)
                .flatMap(this::validateActiveTo)
                .flatMap(this::validateCourseId);
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
}
