package com.schoolonline.app.user.error;

import com.schoolonline.app.common.error.HttpResponseError;

public enum UserError implements HttpResponseError {

    MISSING_FIRSTNAME("Missing first name", 400),
    INVALID_FIRSTNAME("Invalid first name", 400),
    MISSING_LASTNAME("Missing last name", 400),
    INVALID_LASTNAME("Invalid last name", 400),
    MISSING_EMAIL("Missing email", 400),
    INVALID_EMAIL("Invalid email", 400),
    DUPLICATED_EMAIL("Duplicated email", 400),
    MISSING_PASSWORD("Missing password", 400),
    INVALID_PASSWORD("Invalid password", 400),
    STUDENT_NOT_FOUND("Student not found", 404),
    TEACHER_NOT_FOUND("Teacher not found", 404);

    private String errorMessage;

    private int httpStatus;

    private UserError(String errorMessage, int httpStatus) {
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
