package com.schoolonline.app.test.error;

import com.schoolonline.app.common.error.HttpResponseError;

public enum TestError implements HttpResponseError {

    MISSING_NAME("Missing name", 400),
    INVALID_NAME("Invalid name", 400),
    MISSING_ACTIVE_FROM("Missing active from date", 400),
    INVALID_ACTIVE_FROM("Invalid active from date", 400),
    MISSING_ACTIVE_TO("Missing active to date", 400),
    INVALID_ACTIVE_TO("Invalid active to date", 400),
    MISSING_COURSE_ID("Missing course id", 400),
    COURSE_NOT_FOUND("Course not found", 404);

    private String errorMessage;

    private int httpStatus;

    private TestError(String errorMessage, int httpStatus) {
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
