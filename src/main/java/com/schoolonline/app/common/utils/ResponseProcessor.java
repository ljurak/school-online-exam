package com.schoolonline.app.common.utils;

import com.schoolonline.app.common.error.ErrorResponse;
import com.schoolonline.app.common.error.HttpResponseError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseProcessor {

    public static ResponseEntity<?> processResponse(Either<? extends HttpResponseError, ?> response, HttpStatus status) {
        return response
                .map(body -> new ResponseEntity<>(body, status))
                .getOrElseGet(ResponseProcessor::createErrorResponse);
    }

    public static ResponseEntity<?> processResponse(Option<?> response, HttpResponseError error, HttpStatus status) {
        return response
                .map(body -> new ResponseEntity<>(body, status))
                .getOrElse(() -> createErrorResponse(error));
    }

    @SuppressWarnings("rawtypes")
    private static ResponseEntity createErrorResponse(HttpResponseError error) {
        ErrorResponse errorResponse = new ErrorResponse(error.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(error.getHttpStatus()));
    }
}
