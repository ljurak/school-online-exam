package com.schoolonline.app.common.error;

public interface HttpResponseError {
    String getErrorMessage();
    int getHttpStatus();
}
