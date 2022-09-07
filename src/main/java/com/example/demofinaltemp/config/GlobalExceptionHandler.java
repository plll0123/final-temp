package com.example.demofinaltemp.config;

import com.example.demofinaltemp.enums.SuperErrorResult;
import com.example.demofinaltemp.exception.UserException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> duplicateLoginId(final UserException userException) {
        return createErrorResponse(userException.getErrorResult());
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(SuperErrorResult errorResult) {
        return ResponseEntity.status(errorResult.getHttpStatus())
                .body(new ErrorResponse(errorResult.getName(), errorResult.getMessage()));
    }

    @Getter
    @RequiredArgsConstructor
    static class ErrorResponse {
        private final String code;
        private final String message;
    }
}
