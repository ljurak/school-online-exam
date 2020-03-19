package com.schoolonline.app.course;

import com.schoolonline.app.common.utils.Validator;
import com.schoolonline.app.course.dto.NewCourseDTO;
import com.schoolonline.app.course.error.CourseError;
import com.schoolonline.app.user.UserFacade;
import io.vavr.control.Either;

class CourseValidator {

    private Validator validator;

    private UserFacade userFacade;

    CourseValidator(Validator validator, UserFacade userFacade) {
        this.validator = validator;
        this.userFacade = userFacade;
    }

    Either<CourseError, NewCourseDTO> validateCourse(NewCourseDTO newCourseDTO) {
        return validateName(newCourseDTO)
                .flatMap(this::validateStartDate)
                .flatMap(this::validateEndDate)
                .flatMap(this::validateTeacherId);
    }

    private Either<CourseError, NewCourseDTO> validateName(NewCourseDTO newCourseDTO) {
        if (validator.isBlank(newCourseDTO.getName())) {
            return Either.left(CourseError.MISSING_NAME);
        } else if (!validator.hasMaxLength(newCourseDTO.getName(), 100)) {
            return Either.left(CourseError.INVALID_NAME);
        }

        return Either.right(newCourseDTO);
    }

    private Either<CourseError, NewCourseDTO> validateStartDate(NewCourseDTO newCourseDTO) {
        if (validator.isNull(newCourseDTO.getStartDate())) {
            return Either.left(CourseError.MISSING_START_DATE);
        } else if (!validator.isPresentOrFutureDate(newCourseDTO.getStartDate())) {
            return Either.left(CourseError.INVALID_START_DATE);
        }

        return Either.right(newCourseDTO);
    }

    private Either<CourseError, NewCourseDTO> validateEndDate(NewCourseDTO newCourseDTO) {
        if (validator.isNull(newCourseDTO.getEndDate())) {
            return Either.left(CourseError.MISSING_END_DATE);
        } else if (!validator.isEarlierDate(newCourseDTO.getStartDate(), newCourseDTO.getEndDate())) {
            return Either.left(CourseError.INVALID_END_DATE);
        }

        return Either.right(newCourseDTO);
    }

    private Either<CourseError, NewCourseDTO> validateTeacherId(NewCourseDTO newCourseDTO) {
        if (validator.isNull(newCourseDTO.getTeacherId())) {
            return Either.left(CourseError.MISSING_TEACHER_ID);
        } else if (userFacade.findTeacherById(newCourseDTO.getTeacherId()).isEmpty()) {
            return Either.left(CourseError.TEACHER_NOT_FOUND);
        }

        return Either.right(newCourseDTO);
    }
}
