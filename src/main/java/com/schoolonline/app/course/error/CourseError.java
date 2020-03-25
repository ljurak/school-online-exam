package com.schoolonline.app.course.error;

import com.schoolonline.app.common.error.HttpResponseError;

public enum CourseError implements HttpResponseError {

    MISSING_NAME("Missing name", 400),
    INVALID_NAME("Invalid name", 400),
    MISSING_START_DATE("Missing start date", 400),
    INVALID_START_DATE("Invalid start date", 400),
    MISSING_END_DATE("Missing end date", 400),
    INVALID_END_DATE("Invalid end date", 400),
    MISSING_TEACHER_ID("Missing teacher id", 400),
    TEACHER_NOT_FOUND("Teacher not found", 404),
    STUDENT_NOT_FOUND("Student not found", 404),
    COURSE_NOT_FOUND("Course not found", 404);

    private String errorMessage;

    private int httpStatus;

    private CourseError(String errorMessage, int httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }
}
